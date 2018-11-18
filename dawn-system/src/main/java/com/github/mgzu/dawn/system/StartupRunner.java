package com.github.mgzu.dawn.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Run before starting
 * 在启动之前运行
 * @author https://github.com/mgzu
 * */
@Component
@Order(value = 1)
public class StartupRunner implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void run(String... args) throws Exception {
		log.info(">>>>> StartupRunner order 1 <<<<<");
	}

}
