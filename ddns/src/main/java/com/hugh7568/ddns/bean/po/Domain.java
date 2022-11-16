package com.hugh7568.ddns.bean.po;

import com.hugh7568.ddns.bean.BaseBean;
import com.hugh7568.ddns.enums.DomainLevel;
import com.hugh7568.ddns.enums.DomainType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 域名信息
 *
 * @author Hugh
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "sys_domain")
@ApiModel(value = "com.hugh7568.ddns.bean.域名信息")
public class Domain extends BaseBean {

    @Id
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "主键")
    private Long domainId;

    /**
     * 域名名称
     */
    private String domainName;

    /**
     * 二级域名
     */
    private String secondDomainName;

    /**
     * 供应商唯一ID
     */
    private String providerId;

    /**
     * 域名IP地址
     */
    private String domainAddress;
    /**
     * 域名描述
     */
    private String domainDescription;

    /**
     * 解析协议
     */
    private DomainType domainType;

    /**
     * 是否参与更新
     */
    private Boolean isUpdate;

    /**
     * 域名级别
     */
    private DomainLevel domainLevel;

}
