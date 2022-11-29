package com.hugh7568.ddns.bean.po;

import com.hugh7568.ddns.enums.DomainLevel;
import com.hugh7568.ddns.enums.DomainType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 域名信息
 *
 * @author Hugh
 **/
@Data
@Entity
@Table(name = "sys_domain")
@ApiModel(value = "com.hugh7568.ddns.bean.域名信息")
public class Domain {

    @Id
    @GeneratedValue(generator = "JDBC", strategy = GenerationType.IDENTITY)
    @Column(name = "domain_id")
    @ApiModelProperty(value = "主键")
    private Long domainId;

    /**
     * 域名名称
     */
    @Column(name = "domain_name")
    private String domainName;

    /**
     * 二级域名
     */
    @Column(name = "second_domain_name")
    private String secondDomainName;

    /**
     * 供应商唯一ID
     */
    @Column(name = "provider_id")
    private String providerId;

    /**
     * 域名IP地址
     */
    @Column(name = "domain_address")
    private String domainAddress;
    /**
     * 域名描述
     */
    @Column(name = "domain_description")
    private String domainDescription;

    /**
     * 解析协议
     */
    @Column(name = "domain_type")
    private DomainType domainType;

    /**
     * 是否参与更新
     */
    @Column(name = "is_update")
    private Boolean isUpdate;

    /**
     * 域名级别
     */
    @Column(name = "domain_level")
    private DomainLevel domainLevel;

}
