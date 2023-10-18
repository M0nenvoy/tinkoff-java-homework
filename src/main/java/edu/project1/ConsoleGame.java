package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleGame {
    private final static Logger LOGGER = LogManager.getLogger();

    private static final String PROMPT_MESSAGE = "Угадайте букву:";
    private static final String WINNER_MESSAGE = "Вы победитель!";
    private static final String LOSER_MESSAGE = "Вы проиграли";
    private static final String ALREADY_KNOWN_MESSAGE = "Такая буква уже известна";
    private static final String MISS_INPUT_MESSAGE = "Введено больше одного символа. Повторите попытку";
    private static final String HIT_MESSAGE = "Верно!";
    Game game;

    ConsoleGame(Game game) {
        this.game = game;
    }

    public void run() {
        var cin = new Scanner(System.in);
        var shouldRun = true;
        while (shouldRun) {
            LOGGER.info(PROMPT_MESSAGE);
            var line = cin.nextLine();
            if (line.isEmpty()) {
                processEmptyLine();
                continue;
            }

            if (line.length() > 1) {
                LOGGER.info(MISS_INPUT_MESSAGE);
                continue;
            }

            switch (game.processInput(line.charAt(0))) {
                case ALREADY_KNOWN -> {
                    LOGGER.info(ALREADY_KNOWN_MESSAGE);
                }
                case HIT -> {
                    LOGGER.info(HIT_MESSAGE);
                }
                case MISS -> {
                    LOGGER.info("Неверно... Осталось еще {} попыток", game.getAttemptsLeft());
                }
                case WON -> {
                    LOGGER.info(WINNER_MESSAGE);
                    shouldRun = false;
                }
                case LOST -> {
                    LOGGER.info(LOSER_MESSAGE);
                    shouldRun = false;
                }
                default -> throw new IllegalStateException("Не реализовано");
            }
        }
    }

    private void processEmptyLine() {
        LOGGER.info("Слово: " + game.getWordRepresentation());
    }
}
