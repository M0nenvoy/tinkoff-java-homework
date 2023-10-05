package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task2Test {
    private Task2 task;

    @BeforeEach
    void initializeTask() {
        this.task = new Task2();
    }

    @DisplayName("Подсчет цифр - Happy Path")
    @ParameterizedTest
    @CsvSource(
        {"1324,4", "12,2", "120,3", "1200,4"}
    )
    void countDigitsHappyPath(int source, int expected) {
        Assertions.assertThat(task.countDigits(source)).isEqualTo(expected);
    }

    @DisplayName("Подсчет цифр - Нуль")
    @Test
    void countDigitsZero() {
        Assertions.assertThat(task.countDigits(0)).isEqualTo(1);
    }

    @DisplayName("Подсчет цифр - Отрицательные значения")
    @ParameterizedTest
    @CsvSource(
        {"-1324,4", "-12,2", "-120,3", "-1200,4"}
    )
    void countDigitsNegativeValues(int source, int expected) {
        Assertions.assertThat(task.countDigits(source)).isEqualTo(expected);
    }
}
