package com.hugh7568.ddns.converter;

import com.aliyun.alidns20150109.models.DescribeDomainRecordsResponseBody;
import com.hugh7568.ddns.bean.po.Domain;
import com.hugh7568.ddns.enums.DomainType;
import com.hugh7568.ddns.utils.DomainUtil;

/**
 * 类型转换器
 *
 * @author Hugh
 */
public class DomainConverter {

    private static final String SPOT = ".";

    /**
     * 域名信息转换
     *
     * @param record 返回记录
     * @return domain对象
     */
    public static Domain domainConverter(DescribeDomainRecordsResponseBody.DescribeDomainRecordsResponseBodyDomainRecordsRecord record) {
        Domain domain = new Domain();

        domain.setIsUpdate(Boolean.TRUE);
        domain.setDomainType(DomainType.getByName(record.getType()));

        domain.setDomainName(record.getDomainName());
        domain.setSecondDomainName(record.getRR());
        domain.setProviderId(record.getRecordId());
        domain.setDomainAddress(record.getValue());

        //无法区分三级四级域名,所有拼接到一起重新解析等级
        domain.setDomainLevel(DomainUtil.getDomainLevel(record.getRR() + SPOT + record.getDomainName()));
        return domain;
    }
}