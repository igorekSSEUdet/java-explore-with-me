package ru.practicum.stats;

import java.time.format.DateTimeFormatter;

public class Constants {
    public static final String DATE_TIME_STRING = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter DATE_TIME_SPACE = DateTimeFormatter.ofPattern(DATE_TIME_STRING);
    public static final String PAGE_SIZE_STRING = "10";
}