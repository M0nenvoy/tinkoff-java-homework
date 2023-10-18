package edu.project1;

public class Game {

    private int attemptsLeft;
    private boolean won = false;
    private final HiddenWord hiddenWord;

    Game(String word, int attemptsLeft) {
        this.attemptsLeft = attemptsLeft;
        this.hiddenWord = new HiddenWord(word);
    }

    public GameResponse processInput(char input) {
        var status = hiddenWord.reveal(input);
        GameResponse response;
        switch (status) {
            case RevealStatus.ALREADY_KNOWN -> {
                response = GameResponse.ALREADY_KNOWN;
            }
            case RevealStatus.HIT -> {
                this.won |= hiddenWord.isAllRevealed();
                if (this.won) {
                    response = GameResponse.WON;
                } else {
                    response = GameResponse.HIT;
                }
            }
            case RevealStatus.MISS -> {
                this.attemptsLeft -= 1;
                if (this.attemptsLeft > 0) {
                    response = GameResponse.MISS;
                } else {
                    response = GameResponse.LOST;
                }
            }
            default -> throw new IllegalStateException("Невозможно обработать такой ввод");
        }

        return response;
    }

    public int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    public String getWordRepresentation() {
        return this.hiddenWord.toString();
    }

    public boolean isWon() {
        return this.won;
    }

    public boolean isLost() {
        return !this.won && attemptsLeft <= 0;
    }
}
