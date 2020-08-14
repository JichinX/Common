package me.xujichang.lib.common.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormat {
    public static final String DEFAULT = "yyyy-MM-dd HH:mm:ss";

    public static String formatNow(String pattern) {
        DateTimeFormatter vFormatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.now().format(vFormatter);
    }

    public static String formatNow() {
        return formatNow(DEFAULT);
    }

    public static String formatMs(long pTimeMs, String pattern) {
        DateTimeFormatter vFormatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(pTimeMs), ZoneId.systemDefault()).format(vFormatter);
    }

    public static String formatMs(long pNowMs) {
        return formatMs(pNowMs, DEFAULT);
    }

    public static String formatDate(Date pDate) {

        return formatMs(pDate.getTime(), "yyyy-MM-dd 00:00:00");
    }

    public static LocalDateTime parseDate(String pTimeStr, String pPattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pPattern);
        return LocalDateTime.parse(pTimeStr, formatter);
    }
}
