package org.codeaction.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
public class BirthdayConfig {
    @Value("${person.year}")
    private int year;
    @Value("${person.month}")
    private int month;
    @Value("${person.dayOfMonth}")
    private int dayOfMonth;
    @Value("${person.hour}")
    private int hour;
    @Value("${person.minute}")
    private int minute;
    @Value("${person.second}")
    private int second;

    //方法有参数传入
    @Bean("birthday")
    public LocalDateTime dateTime(LocalDate date, LocalTime time) {
        //return LocalDateTime.of(1980, Month.OCTOBER, 11, 12, 20, 15);
        return LocalDateTime.of(date, time);
    }

    @Bean("date")
    public LocalDate date() {
        return LocalDate.of(year, month, dayOfMonth);
    }

    @Bean("time")
    public LocalTime time() {
        return LocalTime.of(hour, minute, second);
    }
}
