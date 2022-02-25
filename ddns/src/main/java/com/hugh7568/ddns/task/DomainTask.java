package com.hugh7568.ddns.task;

import com.hugh7568.ddns.bean.ScheduleTask;
import com.hugh7568.ddns.config.DynamicTaskConfig;
import com.hugh7568.ddns.service.ScheduleTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 域名更新任务
 *
 * @author yuanr
 * @date 2022/01/17 11:09
 **/

@ComponentScan({"com.hugh7568.ddns.mapper", "com.hugh7568.ddns.service"})
@Configuration
public class DomainTask extends DynamicTaskConfig {

    @Autowired
    private ScheduleTaskService scheduleTaskService;

    /**
     * 任务执行逻辑
     */
    @Override
    public void taskService() {
        System.out.println(LocalDateTime.now() + "---IP定时任务线程");
    }

    /**
     * 获取执行周期
     */
    @Override
    public String getCron() {
        System.out.println("开始启动获取数据库");
        ScheduleTask scheduletask = scheduleTaskService.getCron();
        if(Objects.isNull(scheduletask)) {
            return "*/15 * * * * ?";
        } else {
            return scheduletask.getTaskCron();
        }
    }

    @Override
    public String getTaskName() {
        return "domain";
    }
}
