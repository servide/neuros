package co.insou.neuros.neural;

import co.insou.neuros.neural.feed.Activation;

import java.util.List;

public interface Layer extends Networked {

    List<Node> nodes();

    void addNode(Activation activation);

    void addBias();

    default void addNodes(Activation activation, int amount) {
        for (int i = 0; i < amount; i++) {
            this.addNode(activation);
        }
    }

    default Node getNode(int index) {
        return this.nodes().get(index);
    }

    default int size() {
        return nodes().size();
    }

}
