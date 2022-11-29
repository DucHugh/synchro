package com.hugh7568.ddns.client.aliyun;

import com.aliyun.alidns20150109.Client;
import com.aliyun.teaopenapi.models.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云客户端获取
 *
 * @author Hugh
 */
@Configuration
public class AliyunClient {

    @Value("${provider.aliyun.accessKeyId}")
    private String accessKeyId;

    @Value("${provider.aliyun.accessKeySecret}")
    private String accessKeySecret;

    @Value("${provider.aliyun.endpoint}")
    private String endpoint;

    /**
     * 获取客户端
     *
     * @return 阿里云客户端
     * @throws Exception 获取异常
     */
    @Bean
    Client getClient() throws Exception {
        Config config = new Config();
        config.setAccessKeyId(accessKeyId);
        config.setAccessKeySecret(accessKeySecret);
        config.setEndpoint(endpoint);
        return new Client(config);
    }
}
