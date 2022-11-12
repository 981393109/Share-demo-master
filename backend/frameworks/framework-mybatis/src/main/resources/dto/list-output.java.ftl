package ${cfg.outputDtoPackage};

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
@ApiModel(value="${entity}ListOutputDTO", description="${table.comment!}列表")
</#if>
public class ${entity}ListOutputDTO implements Serializable {

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
