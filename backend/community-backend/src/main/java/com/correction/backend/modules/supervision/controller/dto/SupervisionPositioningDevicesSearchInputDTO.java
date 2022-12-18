package com.correction.backend.modules.supervision.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.correction.framework.common.pojo.PageParam;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 电子定位装置审批
 * </p>
 *
 * @author yao
 * @since 2022-12-03
 */
@Getter
@Setter
@ApiModel(value="SupervisionPositioningDevicesSearchInputDTO", description="电子定位装置审批查询表单")
public class SupervisionPositioningDevicesSearchInputDTO  extends PageParam  {


    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "矫正单位Id")
    private Long correctionUnitId;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "1 提出建议  2延长流程 3 解除流程  4免除流程")
    private Integer type;

    @ApiModelProperty(value = "用户id")
    private Long userId;


    @ApiModelProperty(value = "使用情形")
    private Integer caseUse;

    @ApiModelProperty(value = "合议意见")
    private String consensusOpinion;

    @ApiModelProperty(value = "司法区审批意见 1通过 2 不通过")
    private Integer areaApplyOpinion;

    @ApiModelProperty(value = "司法行政审批结果 1通过 2 不通过")
    private Integer justiceApplyOpinion;

    @ApiModelProperty(value = "确认书面告知矫正对象使用电子定位装置 /确认书面告知矫正对象延长电子定位装置/确认书面告知矫正对象解除电子定位装置/确认书面告知矫正对象免除电子定位装置")
    private Integer informCommitOne;

    @ApiModelProperty(value = "确认抄送县级人民检查院")
    private Integer informCommitTwo;

    @ApiModelProperty(value = "叫做对象确认签收《使用电子腕带等得装置告知书》")
    private Integer informCommitThree;

    @ApiModelProperty(value = "确认已给社区矫正对象佩戴电子腕带等定位装置")
    private Integer wearDevice;

    @ApiModelProperty(value = "确认书面告知矫正对象免除电子定位装置申请不通过")
    private Integer informCommitFour;

    @ApiModelProperty(value = "确认抄送县级人民检察院")
    private Integer informCommitFive;

    @ApiModelProperty(value = "0 - 4")
    private Integer progress;

    @ApiModelProperty(value = "进度 0 未审批 1处理中  4结束")
    private Integer applyStatus;

    @ApiModelProperty(value = "")
    private Integer flowStatus;

    @ApiModelProperty(value = "申请人code")
    private Long applyUser;

    @ApiModelProperty(value = "申请人名称")
    private String applyName;

    @ApiModelProperty(value = "申请时间")
    private String applyTime;

    @ApiModelProperty(value = "源申请ID")
    private Long sourceId;

}
