package com.croplanet.memb.config.dbconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Value("${mysql.dataSourceType}")
    private Class<? extends DataSource> dataSourceType;

    @Bean(name = "dataSourceOne")
    @Primary
    @ConfigurationProperties(prefix = "mysql.db1")
    public DataSource dataSourceOne() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "dataSourceTwo")
    @Primary
    @ConfigurationProperties(prefix = "mysql.db2")
    public DataSource dataSourceTwo() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "dataSourceSystem")
    @Primary
    @ConfigurationProperties(prefix = "mysql.dbSystem")
    public DataSource dataSourceSystem() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }


}
