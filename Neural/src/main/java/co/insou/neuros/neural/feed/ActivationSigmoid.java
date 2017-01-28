package co.insou.neuros.neural.feed;

final class ActivationSigmoid implements Activation {

    @Override
    public double activate(double value) {
        return (1 / (1 + Math.pow(Math.E, (value * -1))));
    }

}
