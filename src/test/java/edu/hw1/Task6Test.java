package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Task6Test {
    Task6 task;

    @BeforeEach
    void initializeTask() {
        this.task = new Task6();
    }

    @DisplayName("kaprekar - Happy Path")
    @ParameterizedTest
    @CsvSource({"3524,3087", "8352,6174", "6174,6174"})
    void kaprekarHappyPath(int x, int expected) {
        Assertions
            .assertThat(task.kaprekar(x)).isEqualTo(expected);
    }

    @DisplayName("kaprekar - Неверное число цифр")
    @ParameterizedTest
    @ValueSource(ints = {0, 123, 56789, 10000, 999})
    void kaprekarInvalidNumberOfDigits(int x) {
        Assertions.assertThatThrownBy(() -> task.kaprekar(x)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("kCount - Happy Path")
    @ParameterizedTest
    @CsvSource({"6621,5", "6554,4", "1234,3", "6174,0"})
    void kCountHappyPath(int x, int expected) {
        Assertions
            .assertThat(task.countK(x)).isEqualTo(expected);
    }

    @DisplayName("kCount - Неверное число цифр")
    @ParameterizedTest
    @ValueSource(ints = {0, 123, 56789, 10000, 999})
    void kCountInvalidNumberOfDigits(int x) {
        Assertions.assertThatThrownBy(() -> task.countK(x)).isInstanceOf(IllegalArgumentException.class);
    }
}
