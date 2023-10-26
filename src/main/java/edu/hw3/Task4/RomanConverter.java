package edu.hw3.Task4;

public class RomanConverter {
    private static final int THOUSAND = 1000;
    private static final int HUNDRED = 100;
    private static final int TEN = 10;

    private RomanConverter() {

    }

    public static String convertToRoman(int x) {
        if (x == 0) {
            throw new IllegalArgumentException("Невозможно представить 0");
        }

        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hrns = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] ths = {"", "M", "MM", "MMM"};

        return ths[x / THOUSAND]
            + hrns[(x % THOUSAND) / HUNDRED]
            + tens[(x % HUNDRED) / TEN]
            + ones[x % TEN];
    }
}
