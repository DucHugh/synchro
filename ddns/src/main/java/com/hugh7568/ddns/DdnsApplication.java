package com.hugh7568.ddns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 动态域名解析项目
 * @author Hugh
 */
@EnableAsync
@EnableJpaRepositories
@SpringBootApplication
public class DdnsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DdnsApplication.class, args);
    }
}
