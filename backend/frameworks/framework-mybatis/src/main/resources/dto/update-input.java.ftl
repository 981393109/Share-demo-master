package ${cfg.inputDtoPackage};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Getter
@Setter
<#if cfg.swagger2>
@ApiModel(value="${entity}UpdateInputDTO", description="${table.comment!}修改表单")
</#if>
public class ${entity}UpdateInputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.comment!?length gt 0>
        <#if cfg.swagger2>
    @ApiModelProperty(value = "${field.comment}")
        </#if>
    </#if>
    private ${field.propertyType} ${field.propertyName};

</#list>
<#------------  END 字段循环遍历  ---------->
}
