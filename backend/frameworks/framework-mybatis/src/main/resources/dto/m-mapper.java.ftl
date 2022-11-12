package ${package.Controller?replace("controller","dtomapper")};

import ${cfg.inputDtoPackage}.${entity}CreateInputDTO;
import ${cfg.inputDtoPackage}.${entity}SearchInputDTO;
import ${cfg.inputDtoPackage}.${entity}UpdateInputDTO;
import ${cfg.outputDtoPackage}.${entity}ListOutputDTO;
import ${package.Entity}.${entity};
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：${author}
 * @Description: ${table.comment!} 转换类
 * @Date: ${date}
 */

@Mapper
public interface M${entity}Convert {

    M${entity}Convert INSTANCE = Mappers.getMapper(M${entity}Convert.class);

    ${entity} to${entity}(${entity}SearchInputDTO ${entity?uncap_first}SearchInputDTO);

    ${entity} to${entity}(${entity}CreateInputDTO ${entity?uncap_first}CreateInputDTO);

    ${entity} to${entity}(${entity}UpdateInputDTO ${entity?uncap_first}UpdateInputDTO);

    ${entity}ListOutputDTO toList(${entity} ${entity?uncap_first});

    List<${entity}ListOutputDTO> toList(List<${entity}> ${entity?uncap_first}s);
}