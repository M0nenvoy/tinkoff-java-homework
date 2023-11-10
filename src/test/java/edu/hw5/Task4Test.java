package edu.hw5;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @DisplayName("Валидация пароля - валидный пароль")
    @Test
    void validatePasswordValid() {
        assertThat(Task4.isPasswordValid("Let's go!"))
            .isTrue();
    }

    @DisplayName("Валидация пароля - один символ")
    @Test
    void validatePasswordOneChar() {
        assertThat(Task4.isPasswordValid("~"))
            .isTrue();
    }

    @DisplayName("Валидация пароля - null строка")
    @Test
    void validatePasswordNullString() {
        assertThatThrownBy(() -> Task4.isPasswordValid(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Валидация пароля - невалидный")
    @Test
    void validatePasswordInvalid() {
        assertThat(Task4.isPasswordValid("I am not valid"))
            .isFalse();
    }
}
