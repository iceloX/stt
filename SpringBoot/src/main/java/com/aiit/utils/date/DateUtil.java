package com.aiit.utils.date;

import org.junit.Test;

import java.time.*;
import java.util.Date;

/**
 * @Author icelo
 * @Date 2021/5/7
 * @Descriptions
 */
public class DateUtil {

    public static Date loca2Date(LocalDateTime dateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = dateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

    public static LocalDateTime date2Local(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

        return localDateTime;
    }

    @Test
    public void test(){
        Date date = loca2Date(LocalDateTime.now());
        System.out.println(date.toString());
    }
}
