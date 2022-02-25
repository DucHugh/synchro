package com.hugh7568.ddns.bean;

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
 * @author yuanr
 * @date 2022/02/09 10:52
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
     * 上级域名ID
     * 顶级域名ID为零
     */
    private Long baseDomainId;

    /**
     * 域名名称
     */
    private String domainName;

    /**
     * 域名IP地址
     */
    private String domainAddress;
    /**
     * 域名描述
     */
    private String domainDescription;

    /**
     * TODO 校正枚举类型传值
     * 域名种类
     */
    private DomainType domainType;

    /**
     * 是否参与更新
     */
    private Boolean isUpdate;

}
