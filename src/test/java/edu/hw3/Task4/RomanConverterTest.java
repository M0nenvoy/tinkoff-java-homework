package edu.hw3.Task4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RomanConverterTest {
    @DisplayName("convertToRoman - Happy path")
    @ParameterizedTest
    @CsvSource({
        "2,II", "12,XII", "16,XVI",
        "78,LXXVIII", "90,XC", "99,XCIX"
    })
    void convertToRomanHappyPath(int x, String expected) {
        Assertions
            .assertThat(RomanConverter.convertToRoman(x))
            .isEqualTo(expected);
    }

    @DisplayName("convertToRoman - Ноль. Бросается исключение")
    @Test
    void convertToRomanZeroExceptionThrown() {
        Assertions.assertThatThrownBy(() -> RomanConverter.convertToRoman(0))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("convertToRoman - Отрицательное число. Бросается исключение")
    @Test
    void convertRomanNegativeExceptionThrown() {
        Assertions.assertThatThrownBy(() -> RomanConverter.convertToRoman(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("convertToRoman - Слишком большое число. Бросается исключение")
    @Test
    void convertRomanTooLargeValue() {
        Assertions.assertThatThrownBy(() -> RomanConverter.convertToRoman(4000))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
