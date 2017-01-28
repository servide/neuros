package co.insou.neuros.neural;

public interface Synapse extends Layered {

    double weight();

    Node from();

    Node to();

}
