package co.insou.neuros.neural.feed;

public interface InputType {

    InputType PRE_SCALED = new PreScaledInput();

    static InputType simple(double min, double max) {
        return new InputType() {
            @Override
            public double min() {
                return min;
            }

            @Override
            public double max() {
                return max;
            }
        };
    }

    double min();

    double max();

    default double scale(double value) {
        double min = min();
        return (value - min) / (max() - min);
    }

}
