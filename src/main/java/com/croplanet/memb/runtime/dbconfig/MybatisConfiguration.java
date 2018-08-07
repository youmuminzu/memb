package com.croplanet.memb.runtime.dbconfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@AutoConfigureAfter
@MapperScan({"com.croplanet.memb.dao"})
public class MybatisConfiguration {

    @Value("${mybatis.mapperLocation}")
    private String mapperLocation;

    @Value("${mybatis.configLocation}")
    private String configLocation;

    @Autowired
    private  DataSourceConfiguration dataSourceConfiguration;


    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(routingDataSourceProxy());

        try {
            return sessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }

    }

    @Bean("routingDataSourceProxy")
    public AbstractRoutingDataSource routingDataSourceProxy() {
        Map targetDatabaseSourceMap = dataSourceConfiguration.getAllDatabaseMap();
        AbstractRoutingDataSource routingDataSourceProxy = new RoutingDataSource();
        routingDataSourceProxy.setDefaultTargetDataSource(targetDatabaseSourceMap.get(
                DataSourceConfiguration.Dbs.db1.getName()));
        routingDataSourceProxy.setTargetDataSources(targetDatabaseSourceMap);
        return routingDataSourceProxy;
    }

}
