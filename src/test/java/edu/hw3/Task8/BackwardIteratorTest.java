package edu.hw3.Task8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class BackwardIteratorTest {
    @DisplayName("Happy path")
    @Test
    void happyPath() {
        Assertions
            .assertThat(new BackwardIterator<>(List.of(1, 2, 3)))
            .toIterable()
            .containsExactly(3, 2, 1);
    }

    @DisplayName("Один элемент")
    @Test
    void oneElement() {
        Assertions
            .assertThat(new BackwardIterator<>(List.of(1)))
            .toIterable()
            .containsExactly(1);
    }

    @DisplayName("Пустая коллекция")
    @Test
    void emptyCollection() {
        Assertions
            .assertThat(new BackwardIterator<>(List.of()))
            .toIterable()
            .isEmpty();
    }

    @DisplayName("Null коллекция")
    @Test
    void nullCollection() {
        Assertions.assertThatThrownBy(() -> new BackwardIterator<>(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
