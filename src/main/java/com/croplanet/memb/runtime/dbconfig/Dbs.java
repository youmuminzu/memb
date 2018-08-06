package com.croplanet.memb.runtime.dbconfig;

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
