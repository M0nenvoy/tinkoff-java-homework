package edu.hw1;

public class Task2 {
    private final static int TEN = 10;

    public int countDigits(int x) {
        if (x == 0) {
            return 1;
        }

        int abs = Math.abs(x);
        int counter = 0;

        while (abs > 0) {
            abs /= TEN;
            counter++;
        }

        return counter;
    }
}
