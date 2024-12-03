package com.wjy.practice.config;

import org.apache.ibatis.mapping.Environment;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@ComponentScan("com.wjy")
@MapperScan("com.wjy.practice.mapper")
public class PracticeApplication {

	private static final Logger LOG = LoggerFactory.getLogger(PracticeApplication.class);

	public static void main(String[] args) {
//		SpringApplication.run(PracticeApplication.class, args);
		SpringApplication app = new SpringApplication(PracticeApplication.class);
		ConfigurableEnvironment env = app.run(args).getEnvironment();
		LOG.info("启动成功！！");
		LOG.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
	}

}
