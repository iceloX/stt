package com.aiit.utils.quartz;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 该类提供Quartz的cron表达式与Date之间的转换
 * Created by zhangzh on 2016/8/2.
 */
@Component
public class CronDateUtils {
    private static final String CRON_DATE_FORMAT = "ss mm HH dd MM ? yyyy";

    /**
     * 传入的日期类转化为cron表达式
     * @param date
     * @return
     */
    public static String getCron(final Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(CRON_DATE_FORMAT);
        String formatTimeStr = "";
        if (date != null) {
            formatTimeStr = sdf.format(date);
            formatTimeStr = formatTimeStr.substring(0, formatTimeStr.length() - 4); // 去掉年份；
        }
        return formatTimeStr;
    }


    public static Date getDate(final String cron) {
        if (cron == null) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(CRON_DATE_FORMAT);
        Date date = null;
        try {
            date = sdf.parse(cron);
        } catch (ParseException e) {
            return null;// 此处缺少异常处理,自己根据需要添加
        }
        return date;
    }
}