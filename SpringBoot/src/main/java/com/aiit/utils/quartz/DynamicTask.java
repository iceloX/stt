package com.aiit.utils.quartz;

import com.aiit.config.quartz.DynamicTaskConfig;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Data
public class DynamicTask implements InitializingBean {

    private DynamicTaskConfig dynamicTaskConfig;

    @Autowired
    public void setDynamicTaskConfig(DynamicTaskConfig dynamicTaskConfig) {
        this.dynamicTaskConfig = dynamicTaskConfig;
    }

    String cron = "";

    /**
     * 程序初始化默认启动定时任务
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        testTask();
    }

    public void testTask() throws ParseException {
        String taskName = "testTask";
        cron = "00 06 8 * * ? 2021";
        //判断数据库中是否已经保存了定时时间的配置，有就从数据库中取出赋值给cron,没有就将默认cron的值存入数据库
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =  sdf.parse("2021-05-07 08:16:45");
        cron = CronDateUtils.getCron(date);
        cron = cron.substring(0,cron.length()-4);
        System.out.println(cron);
        //开始定时任务    
        dynamicTaskConfig.startCron(taskName, new Runnable() {
            @Override
            public void run() {
                //业务逻辑
                System.out.println("九点五十五到了");
            }
        }, cron);
    }
}

