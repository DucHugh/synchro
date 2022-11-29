package com.hugh7568.ddns.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.concurrent.Executor;

/**
 * 动态定时任务基础配置
 *
 * @author Hugh
 * @date 2022/01/05 09:10
 **/
@Slf4j
@EnableScheduling
public abstract class DynamicTaskConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        log.info("开始定时任务");
        taskRegistrar.setScheduler(taskScheduler());
        taskRegistrar.addTriggerTask(
                //定时任务逻辑
                this::taskService,
                //检查执行表达式
                triggerContext -> {
                    CronTrigger trigger = new CronTrigger(getCron());
                    return trigger.nextExecutionTime(triggerContext);
                }
        );
    }

    /**
     * 配置定时任务新线程池
     *
     * @return 线程池配置
     */
    public Executor taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.setThreadNamePrefix("ScheduledTask-" + getTaskName());
        taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        taskScheduler.setAwaitTerminationSeconds(60);
        taskScheduler.initialize();
        return taskScheduler;
    }

    /**
     * 任务执行逻辑
     */
    public abstract void taskService();

    /**
     * 执行周期
     *
     * @return 执行周期即cron
     */
    public abstract String getCron();

    /**
     * 执行任务名
     *
     * @return 任务名
     */
    public abstract String getTaskName();
}