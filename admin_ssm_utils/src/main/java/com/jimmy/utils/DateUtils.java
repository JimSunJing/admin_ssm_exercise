package com.jimmy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    // 日期转换成字符串
    public static String date2String(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String timeString = sdf.format(date);
        return timeString;
    }

    // 字符串转换成日期
    public static Date string2Date(String time, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(time);
        return date;
    }

}
