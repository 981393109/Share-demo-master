package ${package.Mapper};

import ${package.Entity}.${entity};
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
//import ${superMapperClassPackage}X;

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}X<${entity}> {

}
</#if>
