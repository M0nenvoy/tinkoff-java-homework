package edu.hw5;

import static org.assertj.core.api.Assertions.*;
import edu.hw5.Task3.DashedDateParser;
import edu.hw5.Task3.DateParser;
import edu.hw5.Task3.DaysAgoDateParser;
import edu.hw5.Task3.SlashedDateParser;
import edu.hw5.Task3.WordDateParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class Task3Test {
    DateParser parser;

    @BeforeEach
    void initParser() {
        this.parser = new DashedDateParser(new SlashedDateParser(new WordDateParser(new DaysAgoDateParser(null))));
    }

    @DisplayName("Парсинг даты с тире")
    @Test
    void dashedDateParse() {
        assertThat(this.parser.parseDate("2020-10-10"))
            .contains(LocalDate.of(2020, 10, 10));
    }

    @DisplayName("Парсинг даты со косыми чертами")
    @Test
    void slashedDateParse() {
        assertThat(this.parser.parseDate("1/3/1976"))
            .contains(LocalDate.of(1976, 3, 1));
    }

    @DisplayName("Парсинг даты на словах")
    @Test
    void wordBasedDateParse() {
        var today = LocalDate.now();
        assertThat(this.parser.parseDate("today"))
            .map(e -> tuple(e.getYear(), e.getMonth(), e.getDayOfMonth()))
            .hasValue(tuple(today.getYear(), today.getMonth(), today.getDayOfMonth()));
    }

    @DisplayName("Парсинг даты по числу дней назад")
    @Test
    void daysAgoDateParse() {
        var daysAgo = LocalDate.now().minusDays(12);
        assertThat(this.parser.parseDate("12 days ago"))
            .map(e -> tuple(e.getYear(), e.getMonth(), e.getDayOfMonth()))
            .hasValue(tuple(daysAgo.getYear(), daysAgo.getMonth(), daysAgo.getDayOfMonth()));
    }
}
