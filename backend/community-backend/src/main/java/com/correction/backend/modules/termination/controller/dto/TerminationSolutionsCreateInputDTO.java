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
 * 期满解矫
 * </p>
 *
 * @author yao
 * @since 2022-12-18
 */
@Getter
@Setter
@ApiModel(value="TerminationSolutionsCreateInputDTO", description="期满解矫创建表单")
public class TerminationSolutionsCreateInputDTO implements Serializable {

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

    @ApiModelProperty(value = "完成对矫正对象的解除矫正审核")
    private Integer solutionsComplete;

    @ApiModelProperty(value = "批准结果")
    private Integer approvalResult;

    @ApiModelProperty(value = "完成矫正对象在矫正中心解矫宣告仪式")
    private Integer declareComplete;

    @ApiModelProperty(value = "矫正对象在《解除社区矫正宣告书》上签字")
    private Integer signatureComplete;

    @ApiModelProperty(value = "完成与安置帮教部门的衔接工作")
    private Integer cohesionComplete;

    @ApiModelProperty(value = "1：立案决定，99 结束")
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

    private Integer sendProveComplete;
}
