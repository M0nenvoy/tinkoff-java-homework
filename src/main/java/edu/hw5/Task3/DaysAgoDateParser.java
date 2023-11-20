package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class DaysAgoDateParser extends DateParser {
    private final static int SPLIT_SIZE = 3;

    public DaysAgoDateParser(DateParser next) {
        super(next);
    }

    @Override
    public Optional<LocalDate> parseDate(String source) {
        String[] split = source.split(" ");
        if (split.length != SPLIT_SIZE
            || (!split[1].equals("day") && !split[1].equals("days"))
            || !split[2].equals("ago")) {
            return this.next != null ? this.next.parseDate(source) : Optional.empty();
        }

        try {
            int daysAgo = Integer.parseInt(split[0]);
            return Optional.of(LocalDate.now().minusDays(daysAgo));
        } catch (NumberFormatException e) {
            return this.next != null ? this.next.parseDate(source) : Optional.empty();
        }
    }
}
