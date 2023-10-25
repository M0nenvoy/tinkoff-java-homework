package edu.project1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    @DisplayName("Game - Неверные угадывания тратят попытки")
    @Test
    void gameMissedGuessesSpendingAttempts() {
        var game = new Game("слово", 5);
        game.processInput('е');
        Assertions
            .assertThat(game.getAttemptsLeft()).isEqualTo(4);
    }

    @DisplayName("Game - Верные угадывания не тратят попытки")
    @Test
    void gameCorrectGuessesNotSpendingAttempts() {
        var game = new Game("слово", 5);
        game.processInput('с');
        Assertions
            .assertThat(game.getAttemptsLeft()).isEqualTo(5);
    }

    @DisplayName("Game - Проигранная игра")
    @Test
    void gameLost() {
        var game = new Game("слово", 1);
        game.processInput('е');
        Assertions
            .assertThat(game.isLost()).isTrue();
    }

    @DisplayName("Game - Выигранная игра")
    @Test
    void gameWon() {
        var game = new Game("ааа", 1);
        game.processInput('а');
        Assertions
            .assertThat(game.isWon()).isTrue();
    }

    @DisplayName("Game - Возвращение сигнала 'уже известно'")
    @Test
    void gameAlreadyKnown() {
        var game = new Game("аб", 3);
        game.processInput('а');
        var status = game.processInput('а');
        Assertions
            .assertThat(status).isEqualTo(GameResponse.ALREADY_KNOWN);
    }

    @DisplayName("Game - Повторное угадывание уже известных символов не тратит попытки")
    @Test
    void gameAlreadyKnownGuessesNotWastingAttempts() {
        var game = new Game("аб", 3);
        game.processInput('а');
        game.processInput('а');
        Assertions
            .assertThat(game.getAttemptsLeft()).isEqualTo(3);
    }
}
