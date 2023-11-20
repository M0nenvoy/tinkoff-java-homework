package edu.hw5;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Calendar;

public class Task2Test {
    @DisplayName("Поиск всех 13 пятниц")
    @Test
    void getFriday13s() {
        assertThat(Task2.getFriday13s(1925))
            .extracting(c -> c.get(Calendar.MONTH))
            .containsExactly(
                1, 2, 10
            );
    }

    @DisplayName("Некорректный год")
    @Test
    void getFriday13sIncorrectYear() {
        assertThatThrownBy(() -> {
            Task2.getFriday13s(-10);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Следующая пятница 13 - Happy path")
    @Test
    void getNextFriday13Hp() {
        assertThat(Task2.getNextFriday13(LocalDate.of(1925, 1, 4)))
            .isEqualTo(LocalDate.of(1925, 2, 13));
    }

    @DisplayName("Следующая пятница 13. null")
    @Test
    void getNextFriday13Null() {
        assertThatThrownBy(() -> {
            Task2.getNextFriday13(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
