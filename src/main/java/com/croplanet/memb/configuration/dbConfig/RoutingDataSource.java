package com.croplanet.memb.configuration.dbConfig;

import com.croplanet.memb.configuration.constConfig.ConstLocalParamKeys;
import com.croplanet.memb.runtime.local.LocalContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;


@Component("routingDataSource")
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Autowired
    private LocalContextHolder localContextHolder;

    @Value("${maxRecordsPerTable}")
    private int tableCapacity;

    @Override
    protected Object determineCurrentLookupKey() {
        String userIdString = localContextHolder.getLocalValue(ConstLocalParamKeys.LOCAL_KEY_USER_ID);
        long userId = Long.parseLong(userIdString);
        int databaseNumber = (int) Math.floor(userId/tableCapacity) + 1;
        String dbName = "db" + String.valueOf(databaseNumber);
        return dbName;
    }


}
