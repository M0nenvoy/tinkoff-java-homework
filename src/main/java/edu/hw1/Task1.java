package edu.hw1;

public class Task1 {
    public final static int ERROR_CODE = -1;
    private final static int SECONDS_IN_MINUTE = 60;

    int minutesToSeconds(String videoLength) {
        String[] split = videoLength.split(":");
        if (split.length != 2) {
            return ERROR_CODE;
        }

        int minutes;
        int seconds;

        try {
            minutes = Integer.parseInt(split[0]);
            seconds = Integer.parseInt(split[1]);
        } catch (NumberFormatException e) {
            return ERROR_CODE;
        }

        if (minutes < 0 || seconds < 0 || seconds >= SECONDS_IN_MINUTE) {
            return ERROR_CODE;
        }

        return SECONDS_IN_MINUTE * minutes + seconds;
    }
}
