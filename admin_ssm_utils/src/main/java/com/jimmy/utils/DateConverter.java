package com.jimmy.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Component
public class DateConverter implements Converter<String, Date> {
    public Date convert(String source) {
        Date result = null;
        try{
            result = DateUtils.string2Date(source,"yyyy-MM-dd'T'HH:mm");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
