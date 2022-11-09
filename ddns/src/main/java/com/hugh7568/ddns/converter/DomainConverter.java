package com.hugh7568.ddns.converter;

import com.aliyun.alidns20150109.models.DescribeDomainRecordsResponseBody;
import com.hugh7568.ddns.bean.po.Domain;
import com.hugh7568.ddns.enums.DomainLevel;
import com.hugh7568.ddns.enums.DomainType;

/**
 * 类型转换器
 *
 * @author Hugh
 */
public class DomainConverter {

    /**
     * 域名信息转换
     *
     * @param record 返回记录
     * @return domain对象
     */
    public static Domain domainConverter(DescribeDomainRecordsResponseBody.DescribeDomainRecordsResponseBodyDomainRecordsRecord record) {
        Domain domain = new Domain();
        domain.setDomainType(DomainType.A);
        domain.setDomainName(record.getRR() + "." + record.getDomainName());
        domain.setProviderId(record.getRecordId());
        domain.setIsUpdate(true);
        domain.setDomainLevel(DomainLevel.SECOND);
        domain.setDomainAddress(record.getValue());
        return domain;
    }

}
