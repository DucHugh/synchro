package com.hugh7568.ddns.client.aliyun.builder;


import com.aliyun.alidns20150109.models.UpdateDomainRecordRequest;
import com.hugh7568.ddns.bean.po.Domain;

/**
 * 阿里云API,域名更新请求构造器
 *
 * @author Hugh
 */
public class UpdateDomainRecordRequestBuilder {

    private UpdateDomainRecordRequest updateDomainRecordRequest;


    public UpdateDomainRecordRequestBuilder() {
        updateDomainRecordRequest = new UpdateDomainRecordRequest();
    }


    public UpdateDomainRecordRequestBuilder(Domain domain) {
        this();
        updateDomainRecordRequest.setRecordId(domain.getProviderId());
        updateDomainRecordRequest.setRR(domain.getSecondDomainName());
        updateDomainRecordRequest.setType(domain.getDomainType().name());
    }

    public UpdateDomainRecordRequestBuilder setCurrentIp(String currentIp) {
        updateDomainRecordRequest.setValue(currentIp);
        return this;
    }

    public UpdateDomainRecordRequestBuilder setSecondDomain(String secondDomain) {
        updateDomainRecordRequest.setRR(secondDomain);
        return this;
    }

    public UpdateDomainRecordRequestBuilder setRecordId(String recordId) {
        updateDomainRecordRequest.setRecordId(recordId);
        return this;
    }

    public UpdateDomainRecordRequestBuilder setType(String type) {
        updateDomainRecordRequest.setType(type);
        return this;
    }

    public UpdateDomainRecordRequest build(){
        return updateDomainRecordRequest;
    }

}
