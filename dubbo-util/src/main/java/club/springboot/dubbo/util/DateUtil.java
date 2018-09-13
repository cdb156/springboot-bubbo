package club.springboot.dubbo.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

/**
 * @author ldj
 * @date 2018/09/13
 * LocalDatetime
 */
public class DateUtil {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmmss");
    private static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyyMM");
    private static final DateTimeFormatter SHORT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyMMdd");
    private static final DateTimeFormatter SHORT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyMMddHHmmss");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     * 返回当前的日期
     *
     * @return LocalDate
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 返回当前时间
     *
     * @return LocalTime
     */
    public static LocalTime getCurrentLocalTime() {
        return LocalTime.now();
    }

    /**
     * 返回当前日期时间
     *
     * @return LocalDateTime = LocalDate + LocalTime
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 以 yyyyMMdd 返回当前日期的字符串
     *
     * @return String yyyyMMdd
     */
    public static String getCurrentDateStr() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * 以 yyMMdd 格式返回当前日期的字符串
     *
     * @return String yyMMdd
     */
    public static String getCurrentShortDateStr() {
        return LocalDate.now().format(SHORT_DATE_FORMATTER);
    }

    /**
     * 以 yyyyMM 格式返回当前日期的字符串
     *
     * @return String yyyyMM
     */
    public static String getCurrentMonthStr() {
        return LocalDate.now().format(MONTH_FORMATTER);
    }

    /**
     * 以 yyyyMMddHHmmss 格式返回当前 日期+ 时间 的字符串
     *
     * @return String yyyyMMddHHmmss
     */
    public static String getCurrentDateTimeStr() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    /**
     * 以 yyMMddHHmmss 格式返回当前 日期+ 时间 的字符串
     *
     * @return String yyMMddHHmmss
     */
    public static String getCurrentShortDateTimeStr() {
        return LocalDateTime.now().format(SHORT_DATETIME_FORMATTER);
    }

    /**
     * 以 HHmmss 格式返回当前 时间 的字符串
     *
     * @return String HHmmss
     */
    public static String getCurrentTimeStr() {
        return LocalTime.now().format(TIME_FORMATTER);
    }

    /**
     * 根据传入的自定义格式返回当前日期的字符串
     *
     * @param pattern 自定义格式
     * @return String 当前日期字符串
     */
    public static String getCurrentDateStr(String pattern) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 根据传入的自定义格式返回当前 日期+时间 的字符串
     *
     * @param pattern 自定义格式
     * @return String 当前 日期+时间 字符串
     */
    public static String getCurrentDateTimeStr(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 根据传入的自定义格式返回当前时间的字符串
     *
     * @param pattern 自定义格式
     * @return String 当前时间字符串
     */
    public static String getCurrentTimeStr(String pattern) {
        return LocalTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate parseLocalDate(String dateStr, String pattern) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalTime parseLocalTime(String timeStr, String pattern) {
        return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatLocalDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatLocalDateTime(LocalDateTime datetime, String pattern) {
        return datetime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatLocalTime(LocalTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate parseLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DATETIME_FORMATTER);
    }

    public static LocalTime parseLocalTime(String timeStr) {
        return LocalTime.parse(timeStr, TIME_FORMATTER);
    }

    public static String formatLocalDate(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    public static String formatLocalDateTime(LocalDateTime datetime) {
        return datetime.format(DATETIME_FORMATTER);
    }

    public static String formatLocalTime(LocalTime time) {
        return time.format(TIME_FORMATTER);
    }

    /**
     * 日期相隔天数
     *
     * @param startDateInclusive 开始时间
     * @param endDateExclusive 结束时间
     * @return int 相隔天数
     */
    public static int periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return Period.between(startDateInclusive, endDateExclusive).getDays();
    }

    /**
     * 日期相隔小时
     *
     * @param startInclusive 开始时间
     * @param endExclusive 结束见
     * @return long 相隔小时数
     */
    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toHours();
    }

    /**
     * 日期相隔分钟
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    /**
     * 日期相隔毫秒数
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMillis();
    }

    /**
     * 是否当天
     *
     * @param date
     * @return
     */
    public static boolean isToday(LocalDate date) {
        return getCurrentLocalDate().equals(date);
    }

    public static Long toEpochMilli(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
