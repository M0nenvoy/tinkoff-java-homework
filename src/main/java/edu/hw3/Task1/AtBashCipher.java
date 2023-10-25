package edu.hw3.Task1;

public class AtBashCipher {
    private AtBashCipher() {
    }

    public static String atbash(String source) {
        if (source == null) {
            throw new IllegalArgumentException("Строка не должна быть null");
        }

        if (source.isEmpty()) {
            throw new IllegalArgumentException("Строка не должна быть пустой");
        }

        var sb = new StringBuilder();
        for (int i = 0; i < source.length(); ++i) {
            sb.append(processChar(source.charAt(i)));
        }

        return sb.toString();
    }

    private static char processChar(char source) {
        return shouldBeMirrored(source) ? mirrorChar(source) : source;
    }

    private static boolean shouldBeMirrored(char source) {
        return source >= 'A' && source <= 'z';
    }

    private static char mirrorChar(char source) {
        if (Character.isUpperCase(source)) {
            return (char) ('A' + 'Z' - source);
        } else {
            return (char) ('a' + 'z' - source);
        }
    }
}
