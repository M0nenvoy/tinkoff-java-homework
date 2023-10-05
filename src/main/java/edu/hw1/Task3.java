package edu.hw1;

import java.util.Arrays;

public class Task3 {
    public boolean isNestable(int[] in, int[] out) {
        if (in == null) {
            throw new IllegalArgumentException("Внутренний массив не может быть null");
        }

        if (in.length == 0) {
            throw new IllegalArgumentException("Внутренний массив не может быть пустым");
        }

        if (out == null) {
            throw new IllegalArgumentException("Внешний массив не может быть null");
        }

        if (out.length < 2) {
            throw new IllegalArgumentException("Внешний массив должен содержать как минимум два значения");
        }

        int inMin = Arrays.stream(in).min().getAsInt();
        int inMax = Arrays.stream(in).max().getAsInt();
        int outMin = Arrays.stream(out).min().getAsInt();
        int outMax = Arrays.stream(out).max().getAsInt();

        return inMin > outMin && inMax < outMax;
    }
}
