package com.correction.backend.modules.survey.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.correction.framework.common.pojo.PageParam;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 委托单位表
 * </p>
 *
 * @author yao
 * @since 2022-11-17
 */
@Getter
@Setter
@ApiModel(value="SurveyEntrustUnitSearchInputDTO", description="委托单位表查询表单")
public class SurveyEntrustUnitSearchInputDTO  extends PageParam  {


    @ApiModelProperty(value = "单位类型,人民法院、人民检察院、公安机关、监狱/看守所")
    private Integer unitType;

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "联系方式")
    private String mobile;

    @ApiModelProperty(value = "单位地址")
    private String unitAddress;

    @ApiModelProperty(value = "组织架构num")
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

}
