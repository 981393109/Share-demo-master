package com.correction.frameworks.mybatis.mybatis.tools;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.correction.frameworks.mybatis.mybatis.core.dataobject.BaseDO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：Suyuan
 * @Description: 基础版代码生成器
 * @Date: 2020/7/22 10:25
 */
@Slf4j
public class SimpleGenerator {
    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        GenerModel generModel = GenUtils.getGenerByProps();
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //开发人员
        gc.setAuthor("yao")
                // 是否覆盖已有文件
                .setFileOverride(true)
                //开启 BaseResultMap
                .setBaseResultMap(true)
                //开启 baseColumnList
                .setBaseColumnList(true)
                // 生成文件的输出目录
                .setOutputDir(generModel.getPack())
                // 是否打开输出目录
                .setOpen(false)
                // 时间类型对应策略
                .setDateType(DateType.ONLY_DATE)
                .setServiceName("%sService")
                // 修改service名称
                .setServiceImplName("%sServiceImpl");

        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(generModel.getDbUrl())
                .setDriverName(generModel.getDriverName())
                .setUsername(generModel.getUsername())
                .setPassword(generModel.getPassword());
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        String models = generModel.getModules();
        pc.setParent("com.correction.backend.modules")
                .setController( models + StringPool.DOT + "controller")
                .setEntity(models + StringPool.DOT + "entity")
                .setService(models + StringPool.DOT + "service")
                .setServiceImpl(models + StringPool.DOT + "service")
                .setMapper(models + StringPool.DOT + "mapper")
                .setXml(models + StringPool.DOT + "xml");
        //父包模块名
//                .setModuleName(models);
        mpg.setPackageInfo(pc);

        // 自定义生成文件
        setTemplateMapper(mpg, generModel);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel)
                // 是否为lombok模型
                .setEntityLombokModel(true)
                // 自定义继承的Controller类全称
                // 自定义继承的Entity类全称
                .setSuperEntityClass(BaseDO.class)
                // 自定义基础的Entity类，公共字段
//                .setSuperEntityColumns("create_by","create_date","update_by","update_date","del_flag","remark")
                //自定义继承的ServiceImpl类全称
//                .setSuperServiceImplClass(BaseService.class)
                // 需要包含的表名，允许正则表达式
                .setInclude(generModel.getTableName().split(","))
                //驼峰转连字符
                .setControllerMappingHyphenStyle(true)
                // 是否生成字段常量
                .setEntityColumnConstant(true)
                // 生成 <code>@RestController</code> 控制器
                .setRestControllerStyle(true)
                // 表前缀
                .setTablePrefix(generModel.getPrefix().split(","));
        mpg.setStrategy(strategy);
        // 模板引擎 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 模板路径配置
        TemplateConfig tc = new TemplateConfig();
//        tc.setController("/simple/controller.java")
                tc.setService("/simple/service.java")
                .setServiceImpl("/simple/serviceImpl.java")
                .setEntity("/simple/entity.java")
                .setMapper("/simple/mapper.java")
                .setXml("/simple/mapper.xml");
        mpg.setTemplate(tc);
        // 生成代码
        mpg.execute();
    }

    private static void setTemplateMapper(AutoGenerator mpg, final GenerModel generModel) {
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】  ${cfg.abc}
        final String parent = mpg.getPackageInfo().getParent();
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("swagger2", true);
                map.put("entityColumnConstant", false);
                map.put("inputDtoPackage", parent + StringPool.DOT + generModel.getModules() + ".dto.input");
                map.put("outputDtoPackage", parent + StringPool.DOT + generModel.getModules() + ".dto.output");
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // DTO生成
        generDTO(generModel, focList, mpg);
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
    }


    /**
     * 生成dto
     *
     * @param generModel
     * @param focList
     */
    private static void generDTO(GenerModel generModel, List<FileOutConfig> focList, AutoGenerator mpg) {
        final String controller = StrUtil.builder().append(mpg.getPackageInfo().getParent()).append(StringPool.DOT).append(mpg.getPackageInfo().getController()).toString();
        final String inputDtoPackage = StrUtil.builder().append(generModel.getPack()).append(StrUtil.replace(StrUtil.replace(controller, "controller", "dto.input"), StringPool.DOT, StringPool.SLASH)).append(StringPool.SLASH).toString();
        final String outputDtoPackage = StrUtil.builder().append(generModel.getPack()).append(StrUtil.replace(StrUtil.replace(controller, "controller", "dto.output"), StringPool.DOT, StringPool.SLASH)).append(StringPool.SLASH).toString();
        final String dtoMapperPackage = StrUtil.builder().append(generModel.getPack()).append(StrUtil.replace(StrUtil.replace(controller, "controller", "dtomapper"), StringPool.DOT, StringPool.SLASH)).append(StringPool.SLASH).toString();
        focList.add(new FileOutConfig("/dto/create-input.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return StrUtil.builder().append(inputDtoPackage).append(tableInfo.getEntityName()).append("CreateInputDTO.java").toString();
            }
        });
        focList.add(new FileOutConfig("/dto/update-input.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {

                return StrUtil.builder().append(inputDtoPackage).append(tableInfo.getEntityName()).append("UpdateInputDTO.java").toString();
            }
        });
        focList.add(new FileOutConfig("/dto/search-input.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return StrUtil.builder().append(inputDtoPackage).append(tableInfo.getEntityName()).append("SearchInputDTO.java").toString();
            }
        });
        focList.add(new FileOutConfig("/dto/list-output.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return StrUtil.builder().append(outputDtoPackage).append(tableInfo.getEntityName()).append("ListOutputDTO.java").toString();
            }
        });

        focList.add(new FileOutConfig("/dto/m-mapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return StrUtil.builder().append(dtoMapperPackage).append("/M").append(tableInfo.getEntityName()).append("Convert.java").toString();
            }
        });

    }

}

