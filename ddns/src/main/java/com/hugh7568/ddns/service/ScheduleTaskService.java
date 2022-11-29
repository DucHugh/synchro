package com.hugh7568.ddns.service;

import com.hugh7568.ddns.bean.po.ScheduleTask;

/**
 * ScheduleTask任务接口
 *
 * @author Hugh
 * @date 2022/02/14 10:40
 **/
public interface ScheduleTaskService {
    /**
     * 获取数据库定时任务表达式
     *
     * @return 定时任务信息
     */
    ScheduleTask getCron();
}
