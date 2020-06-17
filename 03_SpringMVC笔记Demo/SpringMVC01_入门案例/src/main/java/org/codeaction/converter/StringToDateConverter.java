package org.codeaction.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器
 */
public class StringToDateConverter implements Converter<String, Date> {
    private SimpleDateFormat sft;

    public StringToDateConverter() {
        sft = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public Date convert(String s) {
        Date date = null;
        try {
            date = sft.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
