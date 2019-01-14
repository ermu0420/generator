package com.ermu.generator.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author xusonglin
 */
@Data
@Entity
@Table(name = "IDC_TICKET_HIS_T",schema="zxidc_dbms")
@ApiModel(value = "历史工单")
public class IdcTicketHis {
    @Id
    @ApiModelProperty(value = "主键")
    @Column(name = "ID")
    private Long id;

    @ApiModelProperty(value = "客户经理")
    @Column(name = "CUSTOMER_MANAGER_ID")
    private Long customerManagerId;

    @ApiModelProperty(value = "客户经理名称")
    @Column(name = "CUSTOMER_MANAGER_NAME")
    private String customerManagerName;

    @ApiModelProperty(value = "申请人")
    @Column(name = "APPLY_ID")
    private Long applyId;

    @ApiModelProperty(value = "申请名称")
    @Column(name = "APPLY_NAME")
    private String applyName;

    @ApiModelProperty(value = "审批过的人主键")
    @Column(name = "AUDIT_IDS")
    private String auditIds;

    @ApiModelProperty(value = "审批过的名称")
    @Column(name = "AUDIT_NAME")
    private String auditName;

    @ApiModelProperty(value = "业务名称")
    @Column(name = "BUS_NAME")
    private String busName;

    @ApiModelProperty(value = "候选审批人")
    @Column(name = "CANDIDATE")
    private String candidate;

    @ApiModelProperty(value = "候选审批人主键")
    @Column(name = "CANDIDATE_IDS")
    private String candidateIds;

    @ApiModelProperty(value = "创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "CREATE_TIME",columnDefinition = "TIMESTAMP(6) DEFAULT SYSTIMESTAMP ")
    private Date createTime;

    @ApiModelProperty(value = "客户主键")
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @ApiModelProperty(value = "客户名")
    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @ApiModelProperty(value = "结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "END_TIME")
    private Date endTime;

    @ApiModelProperty(value = "表单标识")
    @Column(name = "FORM_KEY")
    private String formKey;

    @ApiModelProperty(value = "是否存在相关工单0不存在，1存在")
    @Column(name = "IS_RELEVANT_TICKET",columnDefinition = "NUMBER(2) DEFAULT 0")
    private Boolean isRelevantTicket;

    @ApiModelProperty(value = "父工单")
    @Column(name = "PARENT_ID",columnDefinition = "NUMBER(20) DEFAULT -1 ")
    private Long parentId;

    @ApiModelProperty(value = "流程定义标识")
    @Column(name = "PROC_DEF_KEY")
    private String procDefKey;

    @ApiModelProperty(value = "关联流程实例主键")
    @Column(name = "PROC_INST_ID")
    private String procInstId;

    @ApiModelProperty(value = "产品类型")
    @Column(name = "PROD_CATEGORY")
    private Integer prodCategory;

    @ApiModelProperty(value = "关联产品实例主键")
    @Column(name = "PROD_INST_ID")
    private Long prodInstId;

    @ApiModelProperty(value = "显示资源分配 1:可以查看资源分配，0不能查看资源分配")
    @Column(name = "RES_ALLOCATION_STATUS")
    private Boolean resAllocationStatus;

    @ApiModelProperty(value = "候选审批角色标识")
    @Column(name = "ROLE_KEY")
    private String roleKey;

    @ApiModelProperty(value = "工单编号")
    @Column(name = "SERIAL_NUMBER")
    private String serialNumber;

    @ApiModelProperty(value = "任务主键")
    @Column(name = "TASK_ID")
    private String taskId;

    @ApiModelProperty(value = "任务名称")
    @Column(name = "TASK_NAME")
    private String taskName;

    @ApiModelProperty(value = "工单是否可修改表单需求")
    @Column(name = "TICKET_UPDATE_STATUS",columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean ticketUpdateStatus;

    @ApiModelProperty(value = "工单类型")
    @Column(name = "TICKET_CATEGORY")
    private String ticketCategory;

    @ApiModelProperty(value = "主键")
    @Column(name = "TICKET_CATEGORY_FROM")
    private String ticketCategoryFrom;

    @ApiModelProperty(value = "主键")
    @Column(name = "TICKET_CATEGORY_TO")
    private String ticketCategoryTo;

    @ApiModelProperty(value = "工单资源是否可编辑")
    @Column(name = "TICKET_RES_HAND_STATUS",columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean ticketResHandStatus;

    @ApiModelProperty(value = "工单状态 0初始化、1运行中、-2作废、-3删除到回收站、2结束、-22作废结束、-23删除结束")
    @Column(name = "TICKET_STATUS",columnDefinition = "NUMBER(4) DEFAULT 0")
    private Integer ticketStatus;

    @ApiModelProperty(value = "审批状态 -1不同意/驳回")
    @Column(name = "SP_STATUS")
    private Integer spStatus;

    @ApiModelProperty(value = "意向IDC的标识")
    @Column(name = "IDC_CODE")
    private String idcCode;

    @ApiModelProperty(value = "工单所属区域主键")
    @Column(name = "REGION_ID")
    private Long regionId;

    @ApiModelProperty(value = "意向IDC的名称")
    @Column(name = "IDC_NAME")
    private String idcName;

    @ApiModelProperty(value = "工单所属区域名称")
    @Column(name = "regionName")
    private String regionName;

    @ApiModelProperty(value = "受理工单主键")
    @Column(name = "ROOT_ID")
    private Long rootId;

    @ApiModelProperty(value = "修改日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @ApiModelProperty(value = "确认状态")
    @Column(name = "CONFIRM_STATUS",columnDefinition = "NUMBER(2) DEFAULT 0")
    private Boolean confirmStatus;
}