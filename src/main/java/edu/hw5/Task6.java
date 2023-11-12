package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {
    private Task6() {

    }

    public static boolean isSubsequence(String haystack, String needle) {
        if (haystack == null) {
            throw new IllegalArgumentException("Невозможно совершить поиск в null строке");
        }

        if (needle == null) {
            throw new IllegalArgumentException("Невозможно совершить поиск по null строке");
        }

        var any = ".*";
        var regexSb = new StringBuilder();
        regexSb.append(any);

        for (int i = 0; i < needle.length(); ++i) {
            regexSb.append(needle.charAt(i));
            regexSb.append(any);
        }

        return Pattern
            .compile(regexSb.toString())
            .matcher(haystack)
            .matches();
    }
}
