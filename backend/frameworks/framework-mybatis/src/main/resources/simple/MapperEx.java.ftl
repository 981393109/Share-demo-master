package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};

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
public interface ${entity}ExMapper extends ${entity}Mapper {
      /**
         * 查询进项数据的结果展示列表
         * @param searchInfo
         * @param Page
         * @return
         */
        Page<ResultShowDto> fetchResultShow(@Param("searchInfo")Map<String, Object> searchInfo,@Param("page") Page page);

        /**
         * 查询进项数据明细的结果展示列表
         * @param searchInfo
         * @param Page
         * @return
         */
        Page<ResultDetailShowDto> fetchResultShowOfDetail(@Param("searchInfo") Map<String, Object> searchInfo,@Param("page") Page page);

        /**
         * 查询所以的数据
         * @returnW
         */
        List<ResultShowDto> fetchAllResultShow(@Param("shenbq") String shenbq);

        /**
         * 查询所有明细记录
         * @param exprotObj
         * @return
         */
        List<ResultDetailShowDto> fetchAllResultShowOfDetail(Map<String, Object> exprotObj);
}
</#if>
