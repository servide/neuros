package co.insou.neuros.neural;

import co.insou.neuros.common.func.If;

import java.util.List;
import java.util.function.Consumer;

public interface Network {

    List<Layer> layers();

    Layer getLayer(int index);

    Layer addLayer();

    void randomizeWeights();

    void input(double[] input);

    void forward();

    double[] output();

    void train(double[] expected);

    default boolean inBounds(int index) {
        return index >= 0 && index < this.layers().size();
    }

    default void ifLayerExists(int index, Consumer<Layer> consumer) {
        If.isTrue(this.inBounds(index)).then(() -> consumer.accept(this.getLayer(index)));
    }

}
