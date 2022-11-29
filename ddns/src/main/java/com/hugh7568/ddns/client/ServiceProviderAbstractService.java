package com.hugh7568.ddns.client;

import com.hugh7568.ddns.bean.po.Domain;

import java.util.List;

/**
 * 域名供应商服务端
 *
 * @author Hugh
 */
public abstract class ServiceProviderAbstractService {

    /**
     * 根据二级域名获取所有二级域名解析记录
     *
     * @param secondDomainName 二级域名
     * @return 域名信息
     */
    public abstract List<Domain> getDomain(String secondDomainName);

    /**
     * 传入当前IP进行解析
     *
     * @param currentIp 当前IP
     * @return 解析结果
     */
    public abstract List<Domain> updateDomain(String currentIp);


    /**
     * 传入当前IP进行解析
     *
     * @param currentIp 当前IP
     * @param domains   域名信息
     * @return 解析结果
     */

    public abstract boolean updateDomain(String currentIp, List<Domain> domains);

}
