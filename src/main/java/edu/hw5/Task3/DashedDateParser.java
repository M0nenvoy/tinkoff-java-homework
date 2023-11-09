package edu.hw5.Task3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

public class DashedDateParser extends DateParser {
    public DashedDateParser(DateParser next) {
        super(next);
    }

    @Override
    public Optional<LocalDate> parseDate(String source) {
        try {
            var date = new SimpleDateFormat("yyyy-MM-dd")
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
