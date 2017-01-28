package co.insou.neuros.neural.impl;

import co.insou.neuros.neural.Layer;
import co.insou.neuros.neural.Network;
import co.insou.neuros.neural.feed.Activation;
import co.insou.neuros.neural.Node;
import co.insou.neuros.neural.Synapse;

import java.util.ArrayList;
import java.util.List;

class NodeImpl implements Node {

    private final Activation activation;
    private final Layer layer;

    private final List<Synapse> behind = new ArrayList<>();
    private final List<Synapse> ahead = new ArrayList<>();

    private double preactivatedValue, currentValue = 0;

    NodeImpl(Layer layer, Activation activation) {
        this.layer = layer;
        this.activation = activation;
        this.behind.addAll(behind);
    }

    void behind(Synapse behind) {
        this.behind.add(behind);
    }

    void ahead(Synapse ahead) {
        this.ahead.add(ahead);
    }

    @Override
    public Activation activation() {
        return this.activation;
    }

    @Override
    public List<Synapse> behind() {
        return this.behind;
    }

    @Override
    public List<Synapse> ahead() {
        return this.ahead;
    }

    @Override
    public Layer getLayer() {
        return this.layer;
    }

    @Override
    public Network getNetwork() {
        return this.layer.getNetwork();
    }

    @Override
    public double input() {
        return this.preactivatedValue;
    }

    @Override
    public double output() {
        return this.currentValue;
    }

    void setValue(double value) {
        this.preactivatedValue = this.currentValue = value;
    }

    void activate() {
        this.currentValue = this.activation.activate(this.currentValue);
    }

}
