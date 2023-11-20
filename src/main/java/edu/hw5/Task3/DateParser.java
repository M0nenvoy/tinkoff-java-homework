package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class DateParser {
    protected final DateParser next;

    DateParser(DateParser next) {
        this.next = next;
    }

    public abstract Optional<LocalDate> parseDate(String source);
}
