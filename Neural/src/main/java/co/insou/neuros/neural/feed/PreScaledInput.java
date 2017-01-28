package co.insou.neuros.neural.feed;

final class PreScaledInput implements InputType {

    @Override
    public double min() {
        return 0;
    }

    @Override
    public double max() {
        return 1;
    }

    @Override
    public double scale(double value) {
        return value;
    }

}
