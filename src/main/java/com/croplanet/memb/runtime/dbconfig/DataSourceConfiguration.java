package com.croplanet.memb.runtime.dbconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfiguration {

    public enum Dbs {
        db1("db1", "db1"),
        db2("db2", "db2");

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getConfigMark() {
            return configMark;
        }

        public void setConfigMark(String configMark) {
            this.configMark = configMark;
        }

        protected String name;
        protected String configMark;
        Dbs(String name, String configMark) {
            this.name = name;
            this.configMark = configMark;
        }

    }

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

    public Map getAllDatabaseMap() {
        Map allDatabases = new HashMap();
        allDatabases.put(Dbs.db1.getName(), dataSourceOne());
        allDatabases.put(Dbs.db2.getName(), dataSourceTwo());
        return allDatabases;
    }

}
