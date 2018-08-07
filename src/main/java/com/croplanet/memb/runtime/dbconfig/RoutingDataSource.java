package com.croplanet.memb.runtime.dbconfig;

import com.croplanet.memb.runtime.local.LocalContextHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;


@Component("routingDataSource")
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Value("${maxRecordsPerTable}")
    private int tableCapacity;

    @Override
    protected Object determineCurrentLookupKey() {
        String userIdString = LocalContextHolder.getLocalValue(LocalContextHolder.LOCAL_KEY_USER_ID);
        long userId = Long.parseLong(userIdString);
        int databaseNumber = (int) Math.floor(userId/tableCapacity) + 1;
        String dbName = "db" + String.valueOf(databaseNumber);
        return dbName;
    }


}
