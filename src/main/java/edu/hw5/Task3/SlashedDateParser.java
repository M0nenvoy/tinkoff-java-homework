package edu.hw5.Task3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

public class SlashedDateParser extends DateParser {
    public SlashedDateParser(DateParser next) {
        super(next);
    }

    @Override
    public Optional<LocalDate> parseDate(String source) {
        try {
            var date = new SimpleDateFormat("dd/MM/yyyy")
                .parse(source);

            return Optional.of(date
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());

        } catch (ParseException e) {
            if (this.next != null) {
                return this.next.parseDate(source);
            }
            return Optional.empty();
        }
    }
}
