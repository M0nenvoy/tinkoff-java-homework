package edu.hw3.Task3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class FreqDictionaryTest {
    @DisplayName("freqDict - Строки")
    @Test
    void freqDictStrings() {
        Assertions
            .assertThat(FreqDictionary.freqDict(
                List.of("this", "and", "that", "and"))
            )
            .contains(
                Assertions.entry("that", 1),
                Assertions.entry("this", 1),
                Assertions.entry("and", 2)
            );
    }

    @DisplayName("freqDict - Целые числа")
    @Test
    void freqDictIntegers() {
        Assertions
            .assertThat(FreqDictionary.freqDict(
                List.of(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)
            ))
            .contains(
                Assertions.entry(1, 1),
                Assertions.entry(2, 2),
                Assertions.entry(3, 3),
                Assertions.entry(4, 4)
            );
    }

    @DisplayName("freqDict - Пустой ввод")
    @Test
    void freqDictEmpty() {
        Assertions
            .assertThat(FreqDictionary.freqDict(List.of()))
            .contains();
    }

    @DisplayName("freqDict - Null на ввод")
    @Test
    void freqDictNull() {
        Assertions.assertThatThrownBy(() -> FreqDictionary.freqDict(null))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
