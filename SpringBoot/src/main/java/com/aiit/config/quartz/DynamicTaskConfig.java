package com.aiit.config.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

@Component
public class DynamicTaskConfig {

    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    //用于存放对应的定时任务
    private Map<String, ScheduledFuture<?>> taskFutures = new ConcurrentHashMap<String, ScheduledFuture<?>>();

    @Autowired
    public void setThreadPoolTaskScheduler(ThreadPoolTaskScheduler threadPoolTaskScheduler) {
        this.threadPoolTaskScheduler = threadPoolTaskScheduler;
    }

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    /**
     * 开始定时任务
     *
     * @param taskId
     * @param task
     * @param cron
     */
    public void startCron(String taskId, Runnable task, String cron) {
        //先把之前的定时任务取消
        stopCron(taskId);
        //提交任务
        ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler.schedule(task, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                //设置定时时间
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExecDate = trigger.nextExecutionTime(triggerContext);
                return nextExecDate;
            }
        });
        //保存任务，用于后面可以取消任务
        taskFutures.put(taskId, scheduledFuture);
    }

    /**
     * 取消定时任务
     *
     * @param taskId
     */
    public void stopCron(String taskId) {
        ScheduledFuture<?> future = taskFutures.get(taskId);
        if (future != null) {
            future.cancel(true);
        }
    }
}

