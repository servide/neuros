package co.insou.neuros.common.func;

import java.util.function.BooleanSupplier;

public final class If {

    public static If isTrue(BooleanSupplier supplier) {
        return If.isTrue(supplier.getAsBoolean());
    }

    public static If isTrue(boolean condition) {
        return new If(condition);
    }

    public static If isFalse(BooleanSupplier supplier) {
        return If.isFalse(supplier.getAsBoolean());
    }

    public static If isFalse(boolean condition) {
        return new If(!condition);
    }

    private final boolean condition;

    private If(boolean condition) {
        this.condition = condition;
    }

    public void then(Runnable runnable) {
        if (this.condition) {
            runnable.run();
        }
    }

}
