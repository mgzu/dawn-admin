package com.github.mgzu.dawn.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 服务启动执行
 * </p>
 *
 * @author https://github.com/mgzu
 * @since 2018-11-20
 */
@Component
@Order(value = 1)
public class StartupRunner implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(String... args) throws Exception {
		System.out.println(">>>>> StartupRunner start,order 1 <<<<<");
		log.info(">>>>> StartupRunner order 1 <<<<<");
	}

}
