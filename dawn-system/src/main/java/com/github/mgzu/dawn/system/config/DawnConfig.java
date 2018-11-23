package com.github.mgzu.dawn.system.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 * 项目配置类
 * </p>
 *
 * @author https://github.com/mgzu
 * @since 2018-11-21
 */
@Configuration
@EnableTransactionManagement
public class DawnConfig {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 数据源事务管理器
	 */
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		log.info(">>>>> transactionManager start <<<<<");
		return new DataSourceTransactionManager(dataSource);
	}

}
