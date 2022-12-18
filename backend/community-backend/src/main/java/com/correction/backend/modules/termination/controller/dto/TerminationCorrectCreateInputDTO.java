package com.correction.backend.modules.termination.controller.dto;

import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 矫正终止
 * </p>
 *
 * @author yao
 * @since 2022-12-18
 */
@Getter
@Setter
@ApiModel(value="TerminationCorrectCreateInputDTO", description="矫正终止创建表单")
public class TerminationCorrectCreateInputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "矫正单位Id")
    private Long correctionUnitId;

    @ApiModelProperty(value = "服刑人员")
    private String userName;

    @ApiModelProperty(value = "服刑人员id")
    private Long userId;

    @ApiModelProperty(value = "监管类型， 暂时默认普管")
    private String supervisionLevel;

    @ApiModelProperty(value = "执行类别")
    private String performType;

    @ApiModelProperty(value = "终止原因")
    private Integer terminationReason;

    @ApiModelProperty(value = "批准结果")
    private Integer approvalResult;

    @ApiModelProperty(value = "是否完成《终止社区矫正通知书》线下抄送。。。")
    private Integer sendDuplicateComplete;

    @ApiModelProperty(value = "解除信息化核查")
    private Integer removeComplete;

    @ApiModelProperty(value = "1：文书制作，99 结束")
    private Integer progress;

    @ApiModelProperty(value = "进度 0 未审批  99结束")
    private Integer applyStatus;

    @ApiModelProperty(value = "申请人code")
    private Long applyUser;

    @ApiModelProperty(value = "申请人名称")
    private String applyName;

    @ApiModelProperty(value = "申请时间")
    private String applyTime;

    @ApiModelProperty(value = "ref")
    private String ref;

    @ApiModelProperty(value = "流程实例id")
    private String processInstanceId;

    @ApiModelProperty(value = "组织id")
    private Long orgNum;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "修改人")
    private String updater;

    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;

    @ApiModelProperty(value = "新增时所需的文书附件")
    private List<SurveyDocumentsFiles> surveyDocumentsFiles;

}
