package org.codeaction.config;

import org.springframework.context.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

@Configuration
@ComponentScan(basePackages = "org.codeaction.bean")
@Import(BirthdayConfig.class)
@PropertySource("classpath:person.properties")
public class MainConfig {
//    //方法有参数传入
//    @Bean("birthday")
//    public LocalDateTime dateTime(LocalDate date, LocalTime time) {
//        //return LocalDateTime.of(1980, Month.OCTOBER, 11, 12, 20, 15);
//        return LocalDateTime.of(date, time);
//    }
//
//    @Bean("date")
//    public LocalDate date() {
//        return LocalDate.of(1980, Month.OCTOBER, 11);
//    }
//
//    @Bean("time")
//    public LocalTime time() {
//        return LocalTime.of(12, 20, 15);
//    }
}
