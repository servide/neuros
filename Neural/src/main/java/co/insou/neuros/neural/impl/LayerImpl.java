package co.insou.neuros.neural.impl;

import co.insou.neuros.common.func.If;
import co.insou.neuros.neural.Layer;
import co.insou.neuros.neural.Network;
import co.insou.neuros.neural.Node;
import co.insou.neuros.neural.Synapse;
import co.insou.neuros.neural.feed.Activation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class LayerImpl implements Layer {

    private final Network network;
    private final List<Node> nodes = new ArrayList<>();
    private final int index;

    LayerImpl(Network network, int index) {
        this.network = network;
        this.index = index;
    }

    @Override
    public List<Node> nodes() {
        return this.nodes;
    }

    @Override
    public void addNode(Activation activation) {
        this.addNode(NeuralFactory.createNode(this, activation));
    }

    @Override
    public void addBias() {
        this.addNode(NeuralFactory.createBias(this));
    }

    private void addNode(Node node) {
        this.attachBehind(node);
        this.attachAhead(node);

        this.nodes.add(node);
    }

    private void attachBehind(Node node) {
        If.isFalse(node.activation() != Activation.BIAS).then(() ->
                this.network.ifLayerExists(
                    this.index - 1,
                    layer -> this.connect(layer.nodes().stream(), Stream.of(node))
                )
        );
    }

    private void attachAhead(Node node) {
        this.network.ifLayerExists(
                this.index + 1,
                layer -> this.connect(Stream.of(node), layer.nodes().stream())
        );
    }

    private void connect(Stream<Node> from, Stream<Node> to) {
        from.forEach(nodeFrom -> to.forEach(nodeTo -> {
            Synapse synapse = NeuralFactory.createSynapse(nodeFrom, nodeTo);

            ((NodeImpl) nodeFrom).ahead(synapse);
            ((NodeImpl) nodeTo).behind(synapse);
        }));
    }

    @Override
    public Network getNetwork() {
        return this.network;
    }

}
