package edu.hw5;

import java.util.regex.Pattern;

public class Task7 {
    private final static Pattern PATTERN_THREE_AND_LONGER_AND_THIRD_IS_ZERO = Pattern.compile("[01]{2}0[01]*");
    private final static Pattern PATTERN_FIRST_AND_LAST_SAME = Pattern.compile("(0[01]*0|1[01]*1)");
    private final static Pattern PATTERN_LENGTH = Pattern.compile("([01]|[01]{2}|[01]{3})");
    private final static String STRING_CANT_BE_NULL = "Строка не может быть null";

    private Task7() {
    }

    public static boolean matches1(String s) {
        if (s == null) {
            throw new IllegalArgumentException(STRING_CANT_BE_NULL);
        }

        return PATTERN_THREE_AND_LONGER_AND_THIRD_IS_ZERO.matcher(s).matches();
    }

    public static boolean matches2(String s) {
        if (s == null) {
            throw new IllegalArgumentException(STRING_CANT_BE_NULL);
        }

        return PATTERN_FIRST_AND_LAST_SAME.matcher(s).matches();
    }

    public static boolean matches3(String s) {
        if (s == null) {
            throw new IllegalArgumentException((STRING_CANT_BE_NULL));
        }

        return PATTERN_LENGTH.matcher(s).matches();
    }
}
