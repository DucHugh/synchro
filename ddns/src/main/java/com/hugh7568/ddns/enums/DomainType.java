package com.hugh7568.ddns.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;

/**
 * 域名类别
 *
 * @author Hugh
 **/
public enum DomainType {
    /**
     * 域名指向 IPv4 地址
     */
    A,
    /**
     * 域名指向另一个域名
     */
    CNAME,
    /**
     * 设置邮箱
     */
    MX,
    /**
     * 域名指向 IPv6 地址
     */
    AAAA,
    /**
     * 域名进行标识和说明
     * 多用来做 SPF 记录（反垃圾邮件）
     */
    TXT,
    URL,
    /**
     * 子域名交给其他 DNS 服务商解析
     */
    NS,
    /**
     * SRV 记录用来标识某台服务器使用了某个服务，常见于微软系统的目录管理
     */
    SRV,
    /**
     * 域名设置 CAA 记录，使网站所有者
     * 可授权指定CA机构为自己的域名颁发证书
     * 以防止HTTPS证书错误签发，从而提高网站安全性
     */
    CAA,
    /**
     * 反向解析则是指将IP地址映射到域名上，需要您与IDC机房或主机服务商联系实现
     */
    PTR;

    public static DomainType getByName(String name) {

        Optional<DomainType> typeOptional = Arrays.stream(DomainType.values())
                .filter(domainType -> StringUtils.equalsIgnoreCase(name, domainType.name()))
                .findAny();

        return typeOptional.orElseThrow(RuntimeException::new);
    }
}
