package co.insou.neuros.neural.feed;

final class ActivationNullify implements Activation {

    @Override
    public double activate(double value) {
        return 0;
    }

}
