package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task4Test {
    Task4 task;

    @BeforeEach
    void initializeTask() {
        this.task = new Task4();
    }

    @DisplayName("Исправление строки - Happy Path")
    @ParameterizedTest
    @CsvSource(
        {"1234,2143", "100010,010001"}
    )
    void fixStringHappyPath(String source, String expected) {
        Assertions
            .assertThat(task.fixString(source)).isEqualTo(expected);
    }

    @DisplayName("Исправление строки - Нечетное число символов")
    @ParameterizedTest
    @CsvSource(
        {"12345,21435", "10011,01101"}
    )
    void fixStringOdd(String source, String expected) {
        Assertions
            .assertThat(task.fixString(source)).isEqualTo(expected);
    }

    @DisplayName("Исправление строки - Пустая строка")
    @Test
    void fixStringEmpty() {
        Assertions
            .assertThat(task.fixString("")).isEqualTo("");
    }

    @DisplayName("Исправление строки - Строка null")
    @Test
    void fixStringNull() {
        Assertions.assertThatThrownBy(() -> task.fixString(null))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
