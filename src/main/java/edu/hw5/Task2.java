package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Task2 {
    private Task2() {

    }

    private final static int MONTHS_IN_YEAR = 12;
    private final static int TARGET_DAY = 13;

    public static List<Calendar> getFriday13s(int year) {

        if (year < 0) {
            throw new IllegalArgumentException("Некорректный год");
        }

        var result = new ArrayList<Calendar>();

        for (int m = 0; m < MONTHS_IN_YEAR; m++) {
            var cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, m);
            cal.set(Calendar.DAY_OF_MONTH, TARGET_DAY);
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                result.add(cal);
            }
        }

        return result;
    }

    public static LocalDate getNextFriday13(LocalDate from) {
        if (from == null) {
            throw new IllegalArgumentException("Начальная дата не может быть null");
        }

        var day = from;
        while (day.getDayOfMonth() != TARGET_DAY) {
            day = day.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return day;
    }
}
