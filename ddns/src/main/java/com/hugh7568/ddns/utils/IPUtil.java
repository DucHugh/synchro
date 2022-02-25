package com.hugh7568.ddns.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 捕获当前外网IP
 *
 * @author yuanr
 * @date 2022/01/17 09:12
 **/
public class IPUtil {

    /**
     * 采用自己服务器接口
     * 自己服务器接口暂时只返回IP
     *
     * 以后回慢慢扩展
     */
    private static String IP_ADDR = "http://ip.yuan9826.com";

    public static String IP = null;


    /**
     * 获取当前主机外网IP
     */
    public static void getIpv4() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(IP_ADDR, String.class);

        if(responseEntity.hasBody()) {
            IP = responseEntity.getBody();
        }
    }


    public static void main(String[] args) {

        getIpv4();
        System.out.println(IP);
    }
}
