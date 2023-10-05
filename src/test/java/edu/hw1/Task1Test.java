package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Task1Test {
    private Task1 task;

    @BeforeEach
    void initializeTask() {
        this.task = new Task1();
    }

    @DisplayName("Длинна видео в секундах - Happy Path")
    @ParameterizedTest
    @CsvSource(
        {"4:20,260", "04:20,260", "00:40,40"}
    )
    void minutesToSecondsHappyPath(String source, int expected) {
        Assertions.assertThat(task.minutesToSeconds(source)).isEqualTo(expected);
    }

    @DisplayName("Длинна видео в секундах - Негативные секунды и минуты")
    @ParameterizedTest
    @ValueSource(
        strings = {"-4:20", "-4:-20", "4:-20"}
    )
    void minutesToSecondsNegative(String source) {
        Assertions.assertThat(task.minutesToSeconds(source)).isEqualTo(Task1.ERROR_CODE);
    }

    @DisplayName("Длинна видео в секундах - Слишком много секунд")
    @ParameterizedTest
    @ValueSource(
        strings = {"00:60", "00:89", "00:2000"}
    )
    void minutesToSecondsExceedingSeconds(String source) {
        Assertions.assertThat(task.minutesToSeconds(source)).isEqualTo(Task1.ERROR_CODE);
    }

    @DisplayName("Длинна видео в секундах - Значение Null")
    @Test
    void minutesToSecondsNull() {
        Assertions.assertThat(task.minutesToSeconds(null)).isEqualTo(Task1.ERROR_CODE);
    }

    @DisplayName("Длинна видео в секундах - Пустая строка")
    @Test
    void minutesToSecondsEmpty() {
        Assertions.assertThat(task.minutesToSeconds("")).isEqualTo(Task1.ERROR_CODE);
    }

    @DisplayName("Длинна видео в секундах - Много двоеточий")
    @Test
    void minutesToSecondsManyColons() {
        Assertions.assertThat(task.minutesToSeconds("12:12:12")).isEqualTo(Task1.ERROR_CODE);
    }
}
