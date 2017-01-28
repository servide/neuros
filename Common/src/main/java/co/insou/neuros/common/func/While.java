package co.insou.neuros.common.func;

import java.util.function.BooleanSupplier;

public final class While {

    public static While isTrue(BooleanSupplier supplier) {
        return While.isTrue(supplier);
    }

    public static While isFalse(BooleanSupplier supplier) {
        return While.isFalse(supplier);
    }

    private final BooleanSupplier supplier;

    private While(BooleanSupplier supplier) {
        this.supplier = supplier;
    }

    public void then(Runnable runnable) {
        if (this.supplier.getAsBoolean()) {
            runnable.run();
        }
    }

}
