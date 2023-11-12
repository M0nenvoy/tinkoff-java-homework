package edu.hw5;

import java.util.regex.Pattern;

public class Task5 {
    private Task5() {

    }

    private final static Pattern PATTERN = Pattern.compile("[А-Я]\\d{3}[А-Я]{2}\\d{3}");

    public static boolean isCarSignatureValid(String signature) {
        if (signature == null) {
            throw new IllegalArgumentException("Знаковый номер не может быть null");
        }

        return PATTERN.matcher(signature).matches();
    }
}
