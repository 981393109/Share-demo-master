package com.correction.framework.common.util.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtils {

    /**
     * 时区 - 默认
     */
    public static final String TIME_ZONE_DEFAULT = "GMT+8";

    public static final String FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND = "yyyy-MM-dd HH:mm:ss";

    //声明需要格式化的格式(日期)
    public static final DateTimeFormatter dfDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //声明需要格式化的格式(日期加时间)
    public static final DateTimeFormatter dfDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static final DateFormat dateFormat = new SimpleDateFormat(FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND);

    public static Date addTime(Duration duration) {
        return new Date(System.currentTimeMillis() + duration.toMillis());
    }

    public static boolean isExpired(Date time) {
        return System.currentTimeMillis() > time.getTime();
    }

    public static long diff(Date endTime, Date startTime) {
        return endTime.getTime() - startTime.getTime();
    }

    /**
     * 创建指定时间
     *
     * @param year        年
     * @param mouth       月
     * @param day         日
     * @return 指定时间
     */
    public static Date buildTime(int year, int mouth, int day) {
        return buildTime(year, mouth, day, 0, 0, 0);
    }

    /**
     * 创建指定时间
     *
     * @param year        年
     * @param mouth       月
     * @param day         日
     * @param hour        小时
     * @param minute      分钟
     * @param second      秒
     * @return 指定时间
     */
    public static Date buildTime(int year, int mouth, int day,
                                 int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, mouth - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, 0); // 一般情况下，都是 0 毫秒
        return calendar.getTime();
    }

    public static Date max(Date a, Date b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        return a.compareTo(b) > 0 ? a : b;
    }

    /**
     * localDate 时间格式化
     */
    public static String formatLocaldateTime (LocalDateTime localDateTime) {
        String format = dfDateTime.format(localDateTime);
        return format;
    }

    public static String formatDate (Date date) {
        String format = dateFormat.format(date);
        return format;
    }


}
