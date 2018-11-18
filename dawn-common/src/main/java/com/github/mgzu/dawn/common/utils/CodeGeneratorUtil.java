package com.github.mgzu.dawn.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.FileSystemResource;

/**
 * @author https://github.com/mgzu
 */
public class CodeGeneratorUtil {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private Properties prop;

	public void generator() throws Exception{
        String basePath = System.getProperty("user.dir");
		try {
			prop = load(basePath);
			log.info("generator.yml is read successful");
		} catch (IllegalAccessException e){
			throw e;
		} catch (Exception e){
			throw e;
		}
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		String projectPath = basePath + "/" + prop.getProperty("module");
		log.info("codePath is:" + projectPath + "/src/main/java");
		gc.setOutputDir(projectPath  + "/src/main/java");
		gc.setAuthor((String) prop.getOrDefault("author", null));
		gc.setOpen((boolean) prop.getOrDefault("open", Boolean.TRUE));
		mpg.setGlobalConfig(gc);
		
		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl(prop.getProperty("db.url"));
		// dsc.setSchemaName("public");
		dsc.setDriverName(prop.getProperty("db.driver-name"));
		dsc.setUsername(prop.getProperty("db.username"));
		dsc.setPassword(prop.getProperty("db.password"));
		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setModuleName(prop.getProperty("project.package.module"));
		pc.setParent(prop.getProperty("project.package.parent"));
		mpg.setPackageInfo(pc);

		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};
		List<FileOutConfig> focList = new ArrayList<>();
		focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输入文件名称
				return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/"
						+ tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
		});
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);
		mpg.setTemplate(new TemplateConfig().setXml(null));

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setSuperEntityClass(prop.getProperty("project.base-entity","com.github.mgzu.dawn.common.entity.BaseEntity"));
		strategy.setEntityLombokModel(Boolean.parseBoolean(prop.getProperty("project.lombok", Boolean.FALSE.toString())));
		strategy.setRestControllerStyle(true);
		strategy.setSuperControllerClass(prop.getProperty("project.base-controller","com.github.mgzu.dawn.common.controller.BaseController"));
		strategy.setInclude(prop.getProperty("table"));
		strategy.setSuperEntityColumns("id");
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setTablePrefix(pc.getModuleName() + "_");
		mpg.setStrategy(strategy);
		mpg.execute();
	}

	private Properties load(String basePath) throws IllegalAccessException{
    	log.info("basePath is:" + basePath);
		YamlPropertiesFactoryBean yml = new YamlPropertiesFactoryBean();
		yml.setResources(new FileSystemResource(basePath + "/dawn-common/src/main/resources/generator.yml"));
		prop = yml.getObject();
		return check(basePath);
	}
	
	private Properties check(String basePath) throws IllegalAccessException{
		if(moduleCheck(basePath, prop.getProperty("module"))) {
			throw new IllegalAccessException("module 配置错误，子模块未找到！");
		}
		stringCheck("db.url");
		stringCheck("db.driver-name");
		stringCheck("db.username");
		stringCheck("db.password");
		stringCheck("table");
		stringCheck("project.package.module");
		stringCheck("project.package.parent");
		return prop;
	}

	private boolean moduleCheck(String basePath, String module){
        String path = basePath + "/" + module;
        log.info("module path:" + path);
    	File file = new File(path);
		return !file.exists();
	}

	private void stringCheck(String key) throws IllegalAccessException {
		if(StringUtils.isBlank(prop.getProperty(key))) {
			throw new IllegalAccessException(key + " 配置错误！");
		}
	}

	/**
	 * 读取控制台内容
	 */
	public static String scanner(String tip) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder help = new StringBuilder();
		help.append("请输入" + tip + "：");
		System.out.println(help.toString());
		if (scanner.hasNext()) {
			String ipt = scanner.next();
			if (StringUtils.isNotEmpty(ipt)) {
				return ipt;
			}
		}
		throw new MybatisPlusException("请输入正确的" + tip + "！");
	}

	public static void main(String[] args) {
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		String projectPath = System.getProperty("user.dir");
		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setAuthor("jobob");
		gc.setOpen(false);
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl("jdbc:mysql://localhost:3306/ant?useUnicode=true&useSSL=false&characterEncoding=utf8");
		// dsc.setSchemaName("public");
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("密码");
		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setModuleName(scanner("模块名"));
		pc.setParent("com.baomidou.ant");
		mpg.setPackageInfo(pc);

		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};
		List<FileOutConfig> focList = new ArrayList<>();
		focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输入文件名称
				return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/"
						+ tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
		});
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);
		mpg.setTemplate(new TemplateConfig().setXml(null));

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(true);
		strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
		strategy.setInclude(scanner("表名"));
		strategy.setSuperEntityColumns("id");
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setTablePrefix(pc.getModuleName() + "_");
		mpg.setStrategy(strategy);
		mpg.execute();
	}
}
