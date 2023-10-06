package edu.hw1;

public class Task4 {
    public String fixString(String source) {
        if (source == null) {
            throw new IllegalArgumentException("Исправляемая строка не может быть null");
        }

        if (source.isEmpty()) {
            return "";
        }

        var sb = new StringBuilder(source.length());
        for (int i = 0; i + 1 < source.length(); i += 2) {
            sb.append(source.charAt(i + 1));
            sb.append(source.charAt(i));
        }

        if (sb.length() < source.length()) {
            sb.append(source.charAt(source.length() - 1));
        }

        return sb.toString();
    }
}
