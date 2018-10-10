package com.croplanet.memb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableRedisHttpSession
@MapperScan("com.croplanet.memb.dao")
public class MembApplication {
	public static void main(String[] args) {
		SpringApplication.run(MembApplication.class, args);
	}
}
