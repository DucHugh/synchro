package com.hugh7568.ddns.client.aliyun.builder;

import com.aliyun.alidns20150109.models.DescribeDomainRecordsRequest;
import com.hugh7568.ddns.bean.po.Domain;
import com.hugh7568.ddns.enums.DomainLevel;

/**
 * 阿里云API,域名查询请求构造器
 *
 * @author Hugh
 */
public class DescribeDomainRecordsRequestBuilder {

    private DescribeDomainRecordsRequest describeDomainRecordsRequest;

    /**
     * 初始化请求
     */
    public DescribeDomainRecordsRequestBuilder() {
        describeDomainRecordsRequest = new DescribeDomainRecordsRequest();
    }

    /**
     * 创建查询请求
     *
     * @param domain 通过域名信息创建请求
     */
    public DescribeDomainRecordsRequestBuilder(Domain domain) {
        this();
        int domainLevel = domain.getDomainLevel().ordinal();

        if (domain.getDomainLevel().equals(DomainLevel.TOP)) {
            describeDomainRecordsRequest.setDomainName(domain.getDomainName());
        } else {
            describeDomainRecordsRequest.setDomainName(domain.getDomainName().split(".", domainLevel + 1)[domainLevel]);
        }
    }

    public DescribeDomainRecordsRequestBuilder setDomainName(String domainName) {
        describeDomainRecordsRequest.setDomainName(domainName);
        return this;
    }

    public DescribeDomainRecordsRequestBuilder setKeyWord(String keyWord) {
        describeDomainRecordsRequest.setKeyWord(keyWord);
        return this;
    }

    public DescribeDomainRecordsRequestBuilder setRRKeyWord(String rrkeyword) {
        describeDomainRecordsRequest.setRRKeyWord(rrkeyword);
        return this;
    }

    public DescribeDomainRecordsRequestBuilder setTypeKeyWord(String typeKeyWord) {
        describeDomainRecordsRequest.setTypeKeyWord(typeKeyWord);
        return this;
    }

    public DescribeDomainRecordsRequest build() {
        return describeDomainRecordsRequest;
    }
}
