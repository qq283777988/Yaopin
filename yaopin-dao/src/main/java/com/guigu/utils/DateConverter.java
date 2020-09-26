package com.guigu.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

    private String[] patterns;

    public void setPatterns(String[] patterns) {
        this.patterns = patterns;
    }

    @Override
    public Date convert(String s) {

        Date dt =null;
        if(StringUtils.isNotBlank(s)){
            //转换日期
            try {
                dt = DateUtils.parseDate(s,patterns);  //根据指定的格式数组  将字符串转成合适的日期
            } catch (ParseException e) {
                return dt;
            }
        }

        return dt;
    }
}
