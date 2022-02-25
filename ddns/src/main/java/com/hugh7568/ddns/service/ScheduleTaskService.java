package com.hugh7568.ddns.service;

import com.hugh7568.ddns.bean.ScheduleTask;

/**
 * ScheduleTask任务接口
 *
 * @author yuanr
 * @date 2022/02/14 10:40
 **/
public interface ScheduleTaskService {

    public ScheduleTask getCron();
}
