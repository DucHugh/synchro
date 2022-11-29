package com.hugh7568.ddns.client.aliyun;

import com.aliyun.alidns20150109.Client;
import com.aliyun.alidns20150109.models.DescribeDomainRecordsRequest;
import com.aliyun.alidns20150109.models.DescribeDomainRecordsResponse;
import com.aliyun.alidns20150109.models.UpdateDomainRecordRequest;
import com.aliyun.alidns20150109.models.UpdateDomainRecordResponse;
import com.aliyun.teautil.models.RuntimeOptions;
import com.hugh7568.ddns.bean.po.Domain;
import com.hugh7568.ddns.client.ServiceProviderAbstractService;
import com.hugh7568.ddns.client.aliyun.builder.DescribeDomainRecordsRequestBuilder;
import com.hugh7568.ddns.client.aliyun.builder.UpdateDomainRecordRequestBuilder;
import com.hugh7568.ddns.converter.DomainConverter;
import com.hugh7568.ddns.exception.ProviderException;
import com.hugh7568.ddns.utils.AssetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 阿里云服务
 *
 * @author Hugh
 */
@Component
public class AliyunService extends ServiceProviderAbstractService {

    @Autowired
    private Client client;

    private static final RuntimeOptions RUNTIME_OPTIONS = new RuntimeOptions();

    private static final String ERROR_MSG = "阿里调用失败";

    @Value("${default-update.domain}")
    private String defaultDomain;

    /**
     * 根据二级域名获取所有二级域名解析记录
     *
     * @param secondDomainName 二级域名
     * @return 获取所有域名信息
     */
    @Override
    public List<Domain> getDomain(String secondDomainName) {

        //构造请求对象
        DescribeDomainRecordsRequest describeDomainRecordsRequest = new DescribeDomainRecordsRequestBuilder()
                .setDomainName(secondDomainName)
                .build();
        List<Domain> domains;
        try {
            //发送请求
            DescribeDomainRecordsResponse describeDomainRecordsResponse = client.describeDomainRecordsWithOptions(describeDomainRecordsRequest, RUNTIME_OPTIONS);

            //断言返回参数不能为空
            AssetUtil.providerError(describeDomainRecordsResponse.getBody(),
                    describeDomainRecordsResponse.getBody().getDomainRecords(),
                    describeDomainRecordsResponse.getBody().getDomainRecords().getRecord());

            //供应商回执参数转换
            domains = describeDomainRecordsResponse.getBody().getDomainRecords().getRecord()
                    .stream()
                    .map(DomainConverter::domainConverter)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ProviderException(ERROR_MSG);
        }
        return domains;
    }

    /**
     * 传入当前IP进行解析
     * <p>
     * 默认更新域名下所有二级域名
     *
     * @param currentIp 当前Ip
     * @return 解析结果
     */
    @Override
    public List<Domain> updateDomain(String currentIp) {
        List<Domain> domains = this.getDomain(defaultDomain);
        this.updateDomain(currentIp, domains);
        return domains;
    }

    /**
     * 传入当前IP进行解析
     *
     * @param currentIp 当前IP
     * @return 解析结果
     */
    @Override
    public boolean updateDomain(String currentIp, List<Domain> domains) throws RuntimeException {
        try {
            for (Domain domain : domains) {
                //构造更新请求
                UpdateDomainRecordRequest build = new UpdateDomainRecordRequestBuilder(domain).setCurrentIp(currentIp).build();
                UpdateDomainRecordResponse updateDomainRecordResponse = client.updateDomainRecord(build);

                //断言返回参数不能为空
                AssetUtil.providerError(updateDomainRecordResponse, updateDomainRecordResponse.getBody());

                //更新回执
                String recordId = updateDomainRecordResponse.getBody().getRecordId();
                domain.setProviderId(recordId);
            }
        } catch (Exception e) {
            throw new ProviderException(ERROR_MSG);
        }
        return true;
    }
}