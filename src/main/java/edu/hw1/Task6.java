package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private static final Task5 TASK5 = new Task5();
    private static final int VALUE_CEIL = 9999;
    private static final int VALUE_FLOOR = 1000;
    private static final int K_CONSTANT = 6174;

    int kaprekar(int x) {
        if (x < VALUE_FLOOR || x > VALUE_CEIL) {
            throw new IllegalArgumentException("Число должно иметь в точности 4 цифры");
        }

        int[] a = TASK5.splitDigits(x);
        int[] asc = Arrays.stream(a).sorted().toArray();

        int[] desc = new int[asc.length];
        for (int i = 0; i < asc.length; ++i) {
            desc[desc.length - i - 1] = asc[i];
        }

        int ascValue = TASK5.mergeDigits(asc);
        int descValue = TASK5.mergeDigits(desc);

        return descValue - ascValue;
    }

    int countK(int x) {
        if (x == K_CONSTANT) {
            return 0;
        }

        return 1 + countK(kaprekar(x));
    }
}
