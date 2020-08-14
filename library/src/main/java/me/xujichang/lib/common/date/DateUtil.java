package me.xujichang.lib.common.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

import me.xujichang.lib.common.system.SystemUtil;


public class DateUtil {

    public static long dayEndMs() {
        LocalDateTime vLocalDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        return vLocalDateTime.toInstant(SystemUtil.getZoneOffset()).toEpochMilli();
    }

    public static long dayStartMs() {
        LocalDateTime vLocalDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        return vLocalDateTime.toInstant(SystemUtil.getZoneOffset()).toEpochMilli();
    }

    /**
     * 获取时间 距离现在时间之前
     *
     * @param pBefore
     * @return Calender
     */
    public static Calendar getCalenderDateBeforeMonth(int pBefore) {
        LocalDateTime vLocalDateTime = LocalDateTime.now();
        LocalDateTime vLocalDateTimeBefore = vLocalDateTime.minusMonths(pBefore);

        Calendar vCalendar = Calendar.getInstance();
        vCalendar.setTimeInMillis(vLocalDateTimeBefore.toInstant(SystemUtil.getZoneOffset()).toEpochMilli());
        return vCalendar;
    }

    /**
     * 获取现在的时间
     *
     * @return calendar
     */
    public static Calendar calenderNow() {
        Calendar vCalendar = Calendar.getInstance();
        vCalendar.setTimeInMillis(LocalDateTime.now().toInstant(SystemUtil.getZoneOffset()).toEpochMilli());
        return vCalendar;
    }

    /**
     * 检测时间是否是正常的范围
     *
     * @param pTimeStart
     * @param pTimeEnd
     * @return
     */
    public static boolean checkIsUseful(String pTimeStart, String pTimeEnd, String pPattern) {

        return checkIsUseful(DateFormat.parseDate(pTimeStart, pPattern), DateFormat.parseDate(pTimeEnd, pPattern));
    }

    private static boolean checkIsUseful(LocalDateTime pStart, LocalDateTime pEnd) {
        return pStart.isBefore(pEnd);
    }

    public static long now() {
        return LocalDateTime.now().toInstant(SystemUtil.getZoneOffset()).toEpochMilli();
    }
}
