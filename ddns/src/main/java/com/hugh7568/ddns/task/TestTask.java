package com.hugh7568.ddns.task;

import com.hugh7568.ddns.config.DynamicTaskConfig;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * 测试线程
 *
 * @author yuanr
 * @date 2022/01/17 11:17
 **/
@Configuration
public class TestTask extends DynamicTaskConfig {
    /**
     * 任务执行逻辑
     */
    @Override
    public void taskService() {

        System.out.println(LocalDateTime.now() + "---test线程");
    }

    /**
     * 获取执行周期
     */
    @Override
    public String getCron() {
        return "*/8 * * * * ?";
    }

    @Override
    public String getTaskName() {
        return "test";
    }
}
