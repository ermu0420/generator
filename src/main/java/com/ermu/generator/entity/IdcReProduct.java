package com.ermu.generator.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author xusonglin
 *
 *  业务订单
 */
@Data
@Entity
@Table(name = "IDC_RE_PRODUCT_T",schema="zxidc_dbms")
@ApiModel(value = "订单产品表")
public class IdcReProduct implements Serializable {
    @Id
    @ApiModelProperty(value = "主键")
    @Column(name = "ID",columnDefinition = "NUMBER(20)")
    private Long id;

    @ApiModelProperty(value = "申请人主键")
    @Column(name = "APPLY_ID",columnDefinition = "NUMBER(20)")
    private Long applyId;

    @ApiModelProperty(value = "申请人名称")
    @Column(name = "APPLY_NAME",columnDefinition = "VARCHAR2(30 char)")
    private String applyName;

    @ApiModelProperty(value = "申请人电话")
    @Column(name="APPLY_PHONE",columnDefinition = "VARCHAR2(30 char)")
    private String applyPhone;

    @ApiModelProperty(value = "申请人角色")
    @Column(name = "APPLY_ROLES",columnDefinition = "VARCHAR2(255 char)")
    private String applyRoles;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "CREATE_TIME",columnDefinition = "TIMESTAMP(6) DEFAULT SYSTIMESTAMP ")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "所属客户主键")
    @Column(name = "CUSTOMER_ID",columnDefinition = "NUMBER(20)")
    private Long customerId;

    @ApiModelProperty(value = "客户名称")
    @Column(name = "CUSTOMER_NAME",columnDefinition = "VARCHAR2(255 char)")
    private String customerName;

    @ApiModelProperty(value = "1激活;0禁用")
    @Column(name = "IS_ACTIVE",length = 2,columnDefinition = "NUMBER(2) DEFAULT 0 ")
    private Integer isActive;

    @ApiModelProperty(value = "订单状态,dict:10,在途;20,已竣工;30,已停机;40,已撤销")
    @Column(name = "PROD_STATUS",length = 4)
    private Integer prodStatus;

    @ApiModelProperty(value = "流程工单状态:10草稿；20预勘中，21已经预勘；30开通中，31已经开通；40停机中，41已经停机；50下线中，51已经下线；60变更中，61已经变更;70复通中，71复通完成")
    @Column(name = "PROC_TICKET_STATUS",length = 4)
    private Integer procTicketStatus;

    @ApiModelProperty(value = "订单类别:1普通业务0自有业务")
    @Column(name = "PROD_CATEGORY",length = 2)
    private Integer prodCategory;

    @ApiModelProperty(value = "订单实例名称")
    @Column(name = "PROD_NAME")
    private String prodName;

    @ApiModelProperty(value = "意向IDC的标识")
    @Column(name = "IDC_CODE")
    private String idcCode;

    @ApiModelProperty(value = "意向IDC的名字")
    @Column(name = "IDC_NAME")
    private String idcName;

    @ApiModelProperty(value = "区域")
    @Column(name = "REGION_ID",length = 20)
    private Long regionId;

    @ApiModelProperty(value = "区域名称")
    @Column(name = "REGION_NAME")
    private String regionName;

    @ApiModelProperty(value = "业务名称")
    @Column(name = "BUS_NAME")
    private String busName;

    @ApiModelProperty(value = "预占有效期（天）")
    @Column(name = "VALIDITY")
    private String validity;
}
