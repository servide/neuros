package co.insou.neuros.neural.impl;

import co.insou.neuros.common.except.InstantiationException;
import co.insou.neuros.neural.Layer;
import co.insou.neuros.neural.Network;
import co.insou.neuros.neural.Node;
import co.insou.neuros.neural.Synapse;
import co.insou.neuros.neural.feed.Activation;

public final class NeuralFactory {

    public static Network createNetwork() {
        return new NetworkImpl();
    }

    static Layer createLayer(Network network, int index) {
        return new LayerImpl(network, index);
    }

    static Node createNode(Layer layer, Activation activation) {
        return new NodeImpl(layer, activation);
    }

    static Node createBias(Layer layer) {
        return new BiasNode(layer);
    }

    static Synapse createSynapse(Node from, Node to) {
        return new SynapseImpl(from, to);
    }

    private NeuralFactory() {
        throw new InstantiationException();
    }

}
