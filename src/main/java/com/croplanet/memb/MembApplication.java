package com.croplanet.memb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
@MapperScan("com.croplanet.memb.dao")
public class MembApplication {
	public static void main(String[] args) {
		SpringApplication.run(MembApplication.class, args);
	}
}
