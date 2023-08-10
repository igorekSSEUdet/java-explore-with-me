package ru.practicum.utility;

import java.time.format.DateTimeFormatter;

public class Formatter {
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Formatter() {
        throw new IllegalStateException("Utility class");
    }
}
