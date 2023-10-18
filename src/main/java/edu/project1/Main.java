package edu.project1;

public final class Main {
    private final static int ATTEMPTS = 5;
    private final static String WORD_TO_GUESS = "страус";

    private Main() {
    }

    public static void main(String[] args) {
        (new ConsoleGame(new Game(WORD_TO_GUESS, ATTEMPTS))).run();
    }
}
