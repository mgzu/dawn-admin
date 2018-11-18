package com.github.mgzu.dawn.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.mgzu.dawn.*.mapper")
public class DwanApplication {
	public static void main(String[] args) {
		SpringApplication.run(DwanApplication.class, args);
	}
}
