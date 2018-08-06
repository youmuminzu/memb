package com.croplanet.memb.runtime.dbconfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter
@MapperScan({"com.croplanet.memb.dao"})
public class MybatisConfiguration {

    @Value("${mybatis.mapperLocation}")
    private String mapperLocation;

    @Value("${mybatis.configLocation}")
    private String configLocation;

    @Qualifier("routingDataSource")
    private  RoutingDataSource routingDataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(routingDataSource);

        try {
            return sessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }

    }

}
