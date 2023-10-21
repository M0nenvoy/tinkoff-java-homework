package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {
    Task3 task;

    @BeforeEach
    void initializeTask() {
        this.task = new Task3();
    }

    @DisplayName("Проверка на вложенность - Happy Path")
    @Test
    void isNestableHappyPath() {
        Assertions
            .assertThat(task.isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6}))
            .isTrue();
    }

    @DisplayName("Проверка на вложенность - Невозможна вложенность")
    @Test
    void isNestableCantNest() {
        Assertions
            .assertThat(task.isNestable(new int[] {1, 2, 3, 4}, new int[] {1, 4}))
            .isFalse();
    }

    @DisplayName("Проверка на вложенность - Пустой внутренний")
    @Test
    void isNestableEmptyIn() {
        Assertions.assertThatThrownBy(()
                -> task
                .isNestable(new int[] {}, new int[] {1, 2, 3, 4}))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Проверка на вложенность - Пустой внешний")
    @Test
    void isNestableEmptyOut() {
        Assertions.assertThatThrownBy(()
                -> task
                .isNestable(new int[] {1, 2, 3, 4}, new int[] {}))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Проверка на вложенность - Null значения")
    @Test
    void isNestableNull() {
        Assertions.assertThatThrownBy(()
                -> task
                .isNestable(null, null))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
