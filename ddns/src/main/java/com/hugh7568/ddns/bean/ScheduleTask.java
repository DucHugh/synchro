package com.hugh7568.ddns.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * schedule_task 定时任务配置文件
 *
 * @author yuanr
 */
@Data
@Entity
@Table(name = "schedule_task")
@ApiModel(value = "ddns.bean.ScheduleTask定时任务")
//@Data
public class ScheduleTask implements Serializable {
    /**
     * 主键
     */
    @Id
    @ApiModelProperty(value = "主键")
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;

    /**
     * 任务名称
     */
    @NotEmpty
    @ApiModelProperty(value = "任务名称")
    @Column(name = "task_name")
    private String taskName;

    /**
     * 任务执行频率
     */
    @NotEmpty
    @ApiModelProperty(value = "任务执行频率")
    @Column(name = "task_cron")
    private String taskCron;

    /**
     * 定时任务锁
     * true正在执行
     * false未执行
     */
    @NotEmpty
    @ApiModelProperty(value = "定时任务锁true正在执行,false未执行")
    private Boolean taskLock;

    /**
     * 任务描述
     */
    @ApiModelProperty(value = "任务描述")
    private String taskComment;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}