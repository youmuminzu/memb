package com.croplanet.memb.config.dbconfig;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@AutoConfigureAfter
@MapperScan({"com.croplanet.memb.dao"})
public class MybatisConfiguration {

    @Value("${mybatis.mapperLocation}")
    private String mapperLocation;

    @Value("${mybatis.configLocation}")
    private String configLocation;

    @Qualifier("dataSourceOne")
    @Autowired
    private DataSource dataSourceOne;

    @Qualifier("dataSourceTwo")
    @Autowired
    private DataSource dataSourceTwo;


    @Qualifier("dataSourceSystem")
    @Autowired
    private DataSource dataSourceSystem;



}
