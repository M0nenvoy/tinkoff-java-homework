package edu.hw5;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Task7Test {
    @DisplayName("Содержит не менее 3 символов, причем третий символ равен 0. Правда")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "010"})
    void match1True(String s) {
        assertThat(Task7.matches1(s)).isTrue();
    }

    @DisplayName("Содержит не менее 3 символов, причем третий символ равен 0. Неправда")
    @ParameterizedTest
    @ValueSource(strings = {"10", "0110"})
    void match1False(String s) {
        assertThat(Task7.matches1(s)).isFalse();
    }

    @DisplayName("Начинается и заканчивается одним и тем же символом")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "011010"})
    void match2True(String s) {
        assertThat(Task7.matches2(s)).isTrue();
    }

    @DisplayName("Начинается и заканчивается одним и тем же символом")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "011011"})
    void match2False(String s) {
        assertThat(Task7.matches2(s)).isFalse();
    }

    @DisplayName("Длина не менее 1 и не более 3")
    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "001"})
    void match3True(String s) {
        assertThat(Task7.matches3(s)).isTrue();
    }

    @DisplayName("Длина не менее 1 и не более 3")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "1011", ""})
    void match3False(String s) {
        assertThat(Task7.matches3(s)).isFalse();
    }
}
