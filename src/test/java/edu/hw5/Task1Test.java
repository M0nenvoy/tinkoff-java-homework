package edu.hw5;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class Task1Test {
    @DisplayName("Продолжительность в минутах")
    @Test
    void durationInMinutes() {
        assertThatCode(() -> {
            assertThat(Task1.getDurationInMinutes("2022-04-01, 21:30", "2022-04-02, 01:20"))
                .isEqualTo(230);
        }).doesNotThrowAnyException();
    }

    @DisplayName("Разбиение строки ввода")
    @Test
    void splitInput() {
        assertThat(Task1.splitLine("2022-03-12, 20:20 - 2022-03-12, 23:50"))
            .containsExactly(
                "2022-03-12, 20:20", "2022-03-12, 23:50"
            );
    }

    @DisplayName("Среднее проведенное время - Happy Path")
    @Test
    void averageTimeSpentHappyPath() {
        assertThat(Task1.getAverageTimeSpentInMinutes(List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        ))).isEqualTo(3 * 60 + 40);
    }

    @DisplayName("Среднее проведенное время - Некорректные данные игнорируются")
    @Test
    void averageTimeSpentDateIncorrect() {
        assertThat(Task1.getAverageTimeSpentInMinutes(List.of(
            "2022.03.12, 20:20 - 2022.03.13, 20:21"
        ))).isEqualTo(0);
    }

    @DisplayName("Pretty print проведенного времени")
    @Test
    void averageTimeSpentPrettyPrint() {
        assertThat(Task1.prettyTimeSpent(Task1.getAverageTimeSpentInMinutes(List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        )))).isEqualTo("3ч 40м");
    }
}
