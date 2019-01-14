package com.ermu.generator.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author xusonglin
 */
@Data
@Entity
@Table(name = "IDC_TICKET_TEST_T")
@ApiModel(value = "测试工单")
public class IdcTicketTest {
    @Id
    @ApiModelProperty(value = "主键")
    @Column(name = "ID")
    private Long id;
    @ApiModelProperty(value = "订单实例主键")
    @Column(name = "PROD_INST_ID")
    private Long prodInstId;
    @ApiModelProperty(value = "工单实例主键")
    @Column(name = "TICKET_INST_ID")
    private Long ticketInstId;

    @ApiModelProperty(value = "测试结束日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "TEST_END_TIME")
    private Date testEndTime;

    @ApiModelProperty(value = "测试开始日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "TEST_START_TIME")
    private Date testStartTime;

    @ApiModelProperty(value = "测试有效期（天）")
    @Column(name = "VALIDITY")
    private String validity;
}