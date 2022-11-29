package com.hugh7568.ddns.task;

import com.hugh7568.ddns.bean.po.ScheduleTask;
import com.hugh7568.ddns.client.ServiceProviderAbstractService;
import com.hugh7568.ddns.service.ScheduleTaskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * 域名更新任务
 *
 * @author Hugh
 **/

@Slf4j
@ComponentScan({"com.hugh7568.ddns.mapper", "com.hugh7568.ddns.service"})
@Configuration
public class DomainTask extends DynamicTaskConfig {

    @Autowired
    private ScheduleTaskService scheduleTaskService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ServiceProviderAbstractService serviceProviderAbstractService;

    @Value("${default-update.current-ip-url}")
    private String currentIpUrl;

    private static final String REDIS_KEY = "IP_ADDRESS";

    private static final String WARNING_MSG = "Redis还未存在该Key";

    /**
     * 任务具体执行逻辑
     * <p>
     * 获取到IP与Redis中IP比较
     * 若相同: 不更新,只保存IP获取记录
     * 若不同: 更新Redis中的IP
     * <p>
     * Redis中存储选类型选择Hash类型
     * 存储值的
     */
    @Override
    public void taskService() {
        log.info("==IP定时获取任务==");
        String ipAddress = restTemplate.getForObject(currentIpUrl, String.class);
        log.info("获取的IP是:{}", ipAddress);

        Boolean result = Boolean.FALSE;
        if (StringUtils.isNotEmpty(ipAddress)) {
            log.info(Objects.requireNonNull(redisTemplate.hasKey(REDIS_KEY), WARNING_MSG).toString());
            if (redisTemplate.hasKey(REDIS_KEY)) {
                String old_ip = redisTemplate.opsForValue().get(REDIS_KEY);
                System.out.println("历史IP:" + old_ip);
                if (old_ip.equals(ipAddress)) {
                    return;
                } else {
                    redisTemplate.opsForValue().set(REDIS_KEY, ipAddress);
                }
            } else {
                result = redisTemplate.opsForValue().setIfPresent(REDIS_KEY, ipAddress);
            }
        }
        log.info(BooleanUtils.isTrue(result) ? "IP地址更新" : "IP地址未捕获到更新");

        //更新域名
        serviceProviderAbstractService.updateDomain(ipAddress);
    }

    /**
     * 获取执行周期
     */
    @Override
    public String getCron() {
        log.info("开始启动获取数据库");
        ScheduleTask scheduletask = scheduleTaskService.getCron();
        if (Objects.isNull(scheduletask)) {
            log.warn("未找到匹配值,启用默认值");
            return "*/15 * * * * ?";
        } else {
            log.info(scheduletask.getTaskCron());
            return scheduletask.getTaskCron();
        }
    }

    @Override
    public String getTaskName() {
        return "domain";
    }
}
