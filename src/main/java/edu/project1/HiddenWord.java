package edu.project1;

import java.util.HashSet;

public class HiddenWord {
    private final String word;
    private final static char UNKNOWN_SYMBOL = '*';
    private final HashSet<Character> revealed = new HashSet<>();

    HiddenWord(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Строка не должна быть null");
        }

        if (word.isEmpty()) {
            throw new IllegalArgumentException("Строка не должна быть пустой");
        }

        if (word.contains(String.valueOf(UNKNOWN_SYMBOL))) {
            throw new IllegalArgumentException("Строка не может содержать символов для сокрытия");
        }

        this.word = word;
    }

    RevealStatus reveal(Character c) {
        if (revealed.contains(c)) {
            return RevealStatus.ALREADY_KNOWN;
        }

        if (word.contains(c.toString())) {
            revealed.add(c);
            return RevealStatus.HIT;
        }

        return RevealStatus.MISS;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (var c : word.toCharArray()) {
            if (revealed.contains(c)) {
                sb.append(c);
            } else {
                sb.append(UNKNOWN_SYMBOL);
            }
        }

        return sb.toString();
    }

    public boolean isAllRevealed() {
        for (var c : word.toCharArray()) {
            if (!revealed.contains(c)) {
                return false;
            }
        }

        return true;
    }
}
