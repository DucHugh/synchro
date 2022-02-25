package com.hugh7568.ddns.service.impl;

import com.hugh7568.ddns.bean.ScheduleTask;
import com.hugh7568.ddns.mapper.ScheduleTaskRepository;
import com.hugh7568.ddns.service.ScheduleTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ScheduleTask任务业务实现类
 *
 * @author yuanr
 * @date 2022/02/14 10:41
 **/
@Service
public class ScheduleTaskServiceImpl implements ScheduleTaskService {


    @Autowired
    private ScheduleTaskRepository scheduleTaskRepository;

    @Override
    public ScheduleTask getCron() {
        final Optional<ScheduleTask> optional = scheduleTaskRepository.findById(1);
        return optional.orElse(null);
    }
}
