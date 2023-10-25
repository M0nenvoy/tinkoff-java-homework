package edu.hw3.Task2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Clusterizer {
    private Clusterizer() {

    }

    public static List<String> clusterize(String source) {
        validate(source);
        var deque = new ArrayDeque<Character>();
        var sb = new StringBuilder();
        var clusters = new ArrayList<String>();
        for (int i = 0; i < source.length(); i++) {
            Character c = source.charAt(i);
            if (c.equals('(')) {
                deque.push(c);
                sb.append(c);
            } else {
                if (deque.isEmpty()) {
                    continue;
                }
                if (deque.peekLast() == '(') {
                    deque.pop();
                    sb.append(')');
                    if (deque.isEmpty()) {
                        clusters.add(sb.toString());
                        sb.setLength(0);
                    }
                }
            }
        }

        return clusters;
    }

    private static void validate(String source) {
        if (source == null) {
            throw new IllegalArgumentException("Строка не может быть null");
        }

        if (source.isEmpty()) {
            throw new IllegalArgumentException("Строка не может быть пустой");
        }

        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != '(' && source.charAt(i) != ')') {
                throw new IllegalArgumentException("Строка должна содержать только '(' и ')'");
            }
        }
    }
}
