package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class WordDateParser extends DateParser {
    public WordDateParser(DateParser next) {
        super(next);
    }

    @Override
    public Optional<LocalDate> parseDate(String source) {
        return switch (source) {
            case "today" -> Optional.of(LocalDate.now());
            case "tomorrow" -> Optional.of(LocalDate.now().plusDays(1));
            case "yesterday" -> Optional.of(LocalDate.now().minusDays(1));
            default -> {
                if (this.next != null) {
                    yield next.parseDate(source);
                }
                yield Optional.empty();
            }
        };
    }
}
