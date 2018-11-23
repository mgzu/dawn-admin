package com.github.mgzu.dawn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * dawn-admin 启动类
 * </p>
 *
 * @author https://github.com/mgzu
 * @since 2018-11-17
 */
@SpringBootApplication
@MapperScan("com.github.mgzu.dawn.*.mapper")
public class DwanApplication {
	public static void main(String[] args) {
		SpringApplication.run(DwanApplication.class, args);
	}
}
