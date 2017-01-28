package co.insou.neuros.neural.feed;

public interface Activation {

    Activation BIAS = new ActivationBias();
    Activation SIGMOID = new ActivationSigmoid();
    Activation LINEAR = new ActivationLinear();
    Activation NULLIFY = new ActivationNullify();

    double activate(double value);

}
