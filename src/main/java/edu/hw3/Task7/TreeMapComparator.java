package edu.hw3.Task7;

import java.util.Comparator;

public class TreeMapComparator {
    private TreeMapComparator() {

    }

    public static Comparator<String> get() {
        return Comparator.nullsLast(Comparator.naturalOrder());
    }
}
