package edu.hw2.Task4;

public final class ReflectionUtils {
    private ReflectionUtils() {
    }

    public static CallingInfo whoCalled() {
        StackTraceElement[] trace;
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            trace = e.getStackTrace();
        }

        try {
            return new CallingInfo(Class.forName(trace[1].getClassName()).getSimpleName(), trace[1].getMethodName());
        } catch (ClassNotFoundException e) {
            /* Сюда мы никогда не попадем */
            return null;
        }
    }
}
