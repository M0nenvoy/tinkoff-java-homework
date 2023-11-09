package edu.hw5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;

public class Task1 {
    private Task1() {

    }

    private static final int MINUTES_IN_HOUR = 60;

    public static String prettyTimeSpent(float minutes) {
        return String.format("%dч %dм", (int) minutes / MINUTES_IN_HOUR, (int) minutes % MINUTES_IN_HOUR);
    }

    public static float getAverageTimeSpentInMinutes(List<String> entries) {
        int minutes = entries
            .stream()
            .map(Task1::splitLine)
            .mapToInt(split -> {
                try {
                    return getDurationInMinutes(split[0], split[1]);
                } catch (ParseException e) {
                    return 0;
                }
            }).sum();

        return (float) minutes / entries.size();
    }

    public static String[] splitLine(String line) {
        return line.split(" - ");
    }

    /**
     * Парсит дату вида yyyy-MM-dd, HH:mm
     */
    public static int getDurationInMinutes(String start, String end) throws ParseException {
        var parser = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
        var startDate = parser.parse(start);
        var endDate = parser.parse(end);
        return (int) Duration.between(startDate.toInstant(), endDate.toInstant()).toMinutes();
    }
}
