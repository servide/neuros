package co.insou.neuros.neural.impl;

import co.insou.neuros.neural.Layer;
import co.insou.neuros.neural.Network;
import co.insou.neuros.neural.Node;
import co.insou.neuros.neural.Synapse;

class SynapseImpl implements Synapse {

    private final Node from;
    private final Node to;

    private double weight;

    SynapseImpl(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Node from() {
        return this.from;
    }

    @Override
    public Node to() {
        return this.to;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    void tune(double weight) {
        this.weight = weight;
    }

    private Node nonNullNode() {
        if (this.from == null && this.to == null) {
            throw new IllegalStateException("nonNullNode() called with two null Nodes!");
        }
        return this.from != null ? this.from : this.to;
    }

    @Override
    public Layer getLayer() {
        return this.nonNullNode().getLayer();
    }

    @Override
    public Network getNetwork() {
        return null;
    }
}
