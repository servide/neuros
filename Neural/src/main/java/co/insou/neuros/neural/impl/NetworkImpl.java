package co.insou.neuros.neural.impl;

import co.insou.neuros.common.string.Strings;
import co.insou.neuros.neural.Layer;
import co.insou.neuros.neural.Network;
import co.insou.neuros.neural.Synapse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class NetworkImpl implements Network {

    private final List<Layer> layers = new ArrayList<>();

    @Override
    public List<Layer> layers() {
        return this.layers;
    }

    @Override
    public Layer getLayer(int index) {
        if (index < 0) {
            throw new NegativeIndexException(index, this.layers.size());
        }

        if (index >= this.layers.size()) {
            throw new IndexOutOfBoundsException(Strings.format("Index: [{0}] , Size: [{1}]", index, this.layers.size()));
        }

        return this.layers.get(index);
    }

    @Override
    public Layer addLayer() {
        Layer layer = NeuralFactory.createLayer(this, this.layers.size());
        this.layers.add(layer);
        return layer;
    }

    @Override
    public void randomizeWeights() {
        this.layers.forEach(layer -> layer.nodes().forEach(node -> node.ahead().forEach(synapse ->
                ((SynapseImpl) synapse).tune(this.randomWeight())
        )));
    }

    private double randomWeight() {
        double value = 0;
        while (value == 0) {
            value = ThreadLocalRandom.current().nextDouble();
        }
        return value;
    }

    @Override
    public void input(double[] input) {
        if (!this.inBounds(0)) {
            throw new IllegalStateException("input() called with empty Network");
        }
        Layer layer = this.getLayer(0);
        if (input.length != layer.size()) {
            throw new IllegalStateException(Strings.format("Input is wrong size, Input: [{0}] , Size: [{1}]", input.length, layer.size()));
        }
        for (int i = 0; i < input.length; i++) {
            NodeImpl node = (NodeImpl) layer.getNode(i);
            node.setValue(input[i]);
        }
    }

    @Override
    public void forward() {
        for (Layer layer : this.layers) {

            layer.nodes().stream().map(node -> (NodeImpl) node).forEach(node -> {

                double value = 0;

                for (Synapse behind : node.behind()) {
                    value += (behind.from().output() * behind.weight());
                }

                node.setValue(value);

                node.activate();

            });

        }

    }

    @Override
    public double[] output() {
        int index = this.layers.size() - 1;

        if (!this.inBounds(index)) {
            throw new IllegalStateException("output() called with empty Network");
        }

        Layer layer = this.getLayer(index);
        double[] output = new double[layer.size()];

        for (int i = 0; i < layer.size(); i++) {
            output[i] = layer.getNode(i).output();
        }

        return output;
    }

    @Override
    public void train(double[] expected) {
        double[] output = this.output();

        if (output.length != expected.length) {
            throw new IllegalArgumentException(Strings.format("train called with wrong sized array , Train: [{0}] , Output: [{1}]", expected.length, output.length));
        }

        double cost = this.cost(output, expected);

        // TODO
    }

    private double cost(double[] output, double[] expected) {
        double total = 0;
        for (int i = 0; i < output.length; i++) {
            total += (Math.pow(output[i] - expected[i], 2) / 2);
        }
        return total;
    }

    private static final class NegativeIndexException extends RuntimeException {

        private NegativeIndexException(int index, int networkSize) {
            super(Strings.format("Index: [{0}] , Size: [{1}]", index, networkSize));
        }

    }

}
