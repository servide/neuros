package co.insou.neuros.common.except;

public class InstantiationException extends RuntimeException {

    public InstantiationException() {
        super("Cannot be instantiated!");
    }

}
