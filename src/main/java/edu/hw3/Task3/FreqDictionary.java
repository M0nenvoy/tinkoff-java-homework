package edu.hw3.Task3;

import java.util.HashMap;
import java.util.List;

public class FreqDictionary {
    private FreqDictionary() {

    }

    public static <T> HashMap<T, Integer> freqDict(List<T> source) {
        if (source == null) {
            throw new IllegalArgumentException("Список не может быть null");
        }

        var freq = new HashMap<T, Integer>();
        for (T x : source) {
            int count = freq.getOrDefault(x, 0) + 1;
            freq.put(x, count);
        }

        return freq;
    }
}
