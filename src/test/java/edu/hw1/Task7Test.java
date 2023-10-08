package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task7Test {
    Task7 task;

    @BeforeEach
    void initializeTask() {
        this.task = new Task7();
    }

    @DisplayName("rotateLeft - Один бит")
    @Test
    void rotateLeftOneBit() {
        Assertions
            .assertThat(task.rotateLeft(0b1000, 2)).isEqualTo(0b0010);
    }

    @DisplayName("rotateLeft - Несколько бит")
    @Test
    void rotateLeftMultipleBits() {
        Assertions
            .assertThat(task.rotateLeft(0b11001, 2)).isEqualTo(0b111);
    }

    @DisplayName("rotateRight - Один бит")
    @Test
    void rotateRightOneBit() {
        Assertions
            .assertThat(task.rotateRight(0b100, 4)).isEqualTo(0b010);
    }

    @DisplayName("rotateRight - Несколько бит")
    @Test
    void rotateRightMultipleBits() {
        Assertions
            .assertThat(task.rotateRight(0b11001, 2)).isEqualTo(0b01110);
    }
}
