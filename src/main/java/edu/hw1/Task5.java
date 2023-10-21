package edu.hw1;

public class Task5 {
    private final static int TEN = 10;

    boolean isPalindromeDescendant(int x) {
        int[] a = splitDigits(x);
        while (a.length > 1) {
            if (isPalindrome(a)) {
                return true;
            }

            a = getDescendant(a);
        }
        return false;
    }

    int[] splitDigits(int x) {
        if (x == 0) {
            return new int[] {0};
        }

        int xAbs = Math.abs(x);

        int arraySize = 0;
        int xCopy = xAbs;
        while (xCopy != 0) {
            xCopy /= TEN;
            arraySize += 1;
        }

        int[] ret = new int[arraySize];

        for (int i = 0; i < ret.length; i++) {
            ret[ret.length - i - 1] = xAbs % TEN;
            xAbs /= TEN;
        }

        return ret;
    }

    int mergeDigits(int[] a) {
        int mult = 1;
        int res = 0;

        for (int i = 0; i < a.length; ++i) {
            res += mult * a[a.length - i - 1];
            mult *= TEN;
        }

        return res;
    }

    boolean isPalindrome(int[] source) {
        if (source == null) {
            throw new IllegalArgumentException("Проверяемый массив не может быть null");
        }

        if (source.length == 0) {
            throw new IllegalArgumentException("Проверяемый массив не может быть пустым");
        }

        int left = 0;
        int right = source.length - 1;

        while (left < right) {
            if (source[left] != source[right]) {
                return false;
            }
            left += 1;
            right -= 1;
        }

        return true;
    }

    boolean isPalindrome(int source) {
        return isPalindrome(splitDigits(source));
    }

    int[] getDescendant(int[] source) {
        if (source == null) {
            throw new IllegalArgumentException("Передаваемый массив не может быть null");
        }

        if (source.length < 2) {
            throw new IllegalArgumentException("Передаваемый массив не может иметь размер меньше двух");
        }

        int[] ret;
        if (source.length % 2 == 0) {
            ret = new int[source.length / 2];
        } else {
            ret = new int[source.length / 2 + 1];
        }

        int i = 0;
        for (; 2 * i + 1 < source.length; i++) {
            ret[i] = source[2 * i] + source[2 * i + 1];
        }

        if (i < ret.length) {
            ret[i] = source[source.length - 1];
        }

        return splitDigits(mergeDigits(ret));
    }
}
