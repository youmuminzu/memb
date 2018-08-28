package com.croplanet.memb.configuration.dbConfig;

import com.croplanet.memb.configuration.constConfig.ConstLocalParamKeys;
import com.croplanet.memb.runtime.http.local.LocalContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {

    @Autowired
    private LocalContextHolder localContextHolder;

    @Value("${maxRecordsPerTable}")
    private int tableCapacity;

    @Override
    protected Object determineCurrentLookupKey() {
        //gave the dbName a default value to avoid mistakes
        String dbName = "db1";
        String userIdString = localContextHolder.getLocalValue(ConstLocalParamKeys.LOCAL_KEY_USER_ID);
        if (userIdString != null && !userIdString.equals("")) {
            long userId = Long.parseLong(userIdString);
            int databaseNumber = (int) Math.floor(userId/tableCapacity) + 1;
            dbName = "db" + String.valueOf(databaseNumber);
        }
        return dbName;
    }


}
