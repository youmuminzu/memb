package com.croplanet.memb.runtime.dbconfig;

import com.croplanet.memb.runtime.local.LocalContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component("routingDataSource")
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Qualifier("dataSourceOne")
    @Autowired
    private DataSource dataSourceOne;

    @Qualifier("dataSourceTwo")
    @Autowired
    private DataSource dataSourceTwo;

    @Value("${maxRecordsPerTable}")
    private int tableCapacity;

    @Override
    protected Object determineCurrentLookupKey() {
        String userIdString = LocalContextHolder.getLocalValue(LocalContextHolder.LOCAL_KEY_USER_ID);
        long userId = Long.parseLong(userIdString);
        int databaseNubmer = (int) Math.ceil(userId/tableCapacity);
        
        return null;
    }

    public AbstractRoutingDataSource getRoutingDataSource() {
        Map<Object, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put(Dbs.db1.getConfigMark(), dataSourceOne);
        dataSourceMap.put(Dbs.db2.getConfigMark(), dataSourceTwo);
    }
}
