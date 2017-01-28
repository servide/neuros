package co.insou.neuros.neural.feed;

final class ActivationBias implements Activation {

    @Override
    public double activate(double value) {
        return 1;
    }

}
