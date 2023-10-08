package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class Task8Test {
    Task8 task;

    @BeforeEach
    void initializeTask() {
        this.task = new Task8();
    }

    private static Stream<Arguments> provideBoards() {
        return Stream.of(
            Arguments.of((Object) new int[][] {
                new int[] {0, 0, 0, 1, 0, 0, 0, 0},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                new int[] {0, 1, 0, 0, 0, 1, 0, 0},
                new int[] {0, 0, 0, 0, 1, 0, 1, 0},
                new int[] {0, 1, 0, 0, 0, 1, 0, 0},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                new int[] {0, 1, 0, 0, 0, 0, 0, 1},
                new int[] {0, 0, 0, 0, 1, 0, 0, 0},
            }, true)
        );
    }

    @DisplayName("knightBoardCapture - Истина")
    @Test
    void knightBoardCaptureTrue() {
        var board = new int[][] {
            new int[] {0, 0, 0, 1, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 1, 0, 0, 0, 1, 0, 0},
            new int[] {0, 0, 0, 0, 1, 0, 1, 0},
            new int[] {0, 1, 0, 0, 0, 1, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 1, 0, 0, 0, 0, 0, 1},
            new int[] {0, 0, 0, 0, 1, 0, 0, 0}
        };

        Assertions
            .assertThat(task.knightBoardCapture(board)).isTrue();
    }

    @DisplayName("knightBoardCapture - Ложь")
    @Test
    void knightBoardCaptureFalse() {
        var board = new int[][] {
            new int[] {1, 0, 1, 0, 1, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 1, 0, 0, 0, 1, 0, 0},
            new int[] {0, 0, 0, 0, 1, 0, 1, 0},
            new int[] {0, 1, 0, 0, 0, 1, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 1, 0, 0, 0, 0, 0, 1},
            new int[] {0, 0, 0, 0, 1, 0, 0, 0}
        };

        Assertions
            .assertThat(task.knightBoardCapture(board)).isFalse();
    }
}
