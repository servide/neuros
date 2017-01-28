package co.insou.neuros.common.string;

import co.insou.neuros.common.except.InstantiationException;

public final class Strings {

    public static String format(String string, Object... args) {
        if (string == null) {
            return "";
        }

        if (args == null) {
            return string;
        }

        for (int i = 0; i < args.length; i++) {
            string = string.replace("{" + i + "}", String.valueOf(args[i]));
        }

        return string;
    }

    private Strings() {
        throw new InstantiationException();
    }

}
