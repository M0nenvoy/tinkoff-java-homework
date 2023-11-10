package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {
    private Task4() {

    }

    private final static Pattern PATTERN = Pattern.compile(".*([~!@#$%^&*|]+).*");

    public static boolean isPasswordValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Пароль не может быть null");
        }
        return PATTERN.matcher(password).matches();
    }
}
