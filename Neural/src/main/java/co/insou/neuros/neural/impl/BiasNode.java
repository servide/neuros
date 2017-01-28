package co.insou.neuros.neural.impl;

import co.insou.neuros.neural.Layer;
import co.insou.neuros.neural.feed.Activation;

class BiasNode extends NodeImpl {

    BiasNode(Layer layer) {
        super(layer, Activation.BIAS);
    }

    @Override
    public double output() {
        return 1;
    }

}
