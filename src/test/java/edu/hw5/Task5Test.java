package edu.hw5;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Task5Test {
    @DisplayName("Корректные номера")
    @ParameterizedTest
    @ValueSource(strings = {"А123ВЕ777", "О777ОО777"})
    void correctSignatures(String signature) {
        assertThat(Task5.isCarSignatureValid(signature)).isTrue();
    }

    @DisplayName("Некорректные номера")
    @ParameterizedTest
    @ValueSource(strings = {"123АВЕ777", "А123ВГ77", "А123ВЕ7777"})
    void incorrectSignature(String signature) {
        assertThat(Task5.isCarSignatureValid(signature)).isFalse();
    }

    @DisplayName("null аргумент")
    @Test
    void nullArgument() {
        assertThatThrownBy(() -> Task5.isCarSignatureValid(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
