package com.croplanet.memb.runtime.local;

import java.util.HashMap;
import java.util.Map;

public class LocalContextHolder {
    //保存thread threadLocal user id的key
    public static final String LOCAL_KEY_USER_ID = "threadUserId";

    //保存thread threadLocal database
    public static final String LOCAL_KEY_DATA_BASE = "threadDataBase";

    public static ThreadLocal<Map<String,String>> threadLocal = new ThreadLocal<>();

    public static void setLocal(String key, String value) {
        Map<String, String> bufferedMap = threadLocal.get();
        if (bufferedMap == null) {
            bufferedMap = new HashMap<>();
        }
        bufferedMap.put(key, value);
        threadLocal.set(bufferedMap);
    }

    public static String getLocalValue(String key) {
        Map<String, String> localMap = threadLocal.get();
        if (localMap == null) {
            return null;
        }
        return localMap.get(key);
    }

    public static Map<String, String> getLocalMap() {
        Map<String, String> localMap = threadLocal.get();
        return localMap;
    }
}
