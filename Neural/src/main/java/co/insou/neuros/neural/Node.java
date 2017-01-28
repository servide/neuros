package co.insou.neuros.neural;

import co.insou.neuros.neural.feed.Activation;

import java.util.List;

public interface Node extends Layered {

    List<Synapse> behind();

    List<Synapse> ahead();

    Activation activation();

    double input();

    double output();

}
