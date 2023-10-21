package edu.hw1;

public class Task7 {
    void validateRotateInput(int n, int shift) {
        if (n < 0) {
            throw new IllegalArgumentException("Сдвигаемое число должно быть не меньше нуля");
        }

        if (shift < 0) {
            throw new IllegalArgumentException("Сдвиг должен быть не меньше нуля");
        }
    }

    int rotateLeft(int n, int shift) {
        validateRotateInput(n, shift);

        int maxBit = Integer.highestOneBit(n);
        int mask = 2 * maxBit - 1;
        int res = n;
        for (int i = 0; i < shift; i++) {
            int nRes = mask & (res << 1);

            if ((res & maxBit) != 0) {
                nRes += 1;
            }

            res = nRes;
        }

        return res;
    }

    int rotateRight(int n, int shift) {
        validateRotateInput(n, shift);

        int maxBit = Integer.highestOneBit(n);
        int res = n;

        for (int i = 0; i < shift; i++) {
            res = (res >> 1) + ((res & 1) * maxBit);
        }

        return res;
    }
}
