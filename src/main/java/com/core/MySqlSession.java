package com.core;

public class MySqlSession {

    private MyExector myExector;

    private Configuration configuration;

    public MySqlSession(MyExector myExector, Configuration configuration) {
        this.myExector = myExector;
        this.configuration = configuration;
    }

    public <T> T getMapper(Class clazz){
        return configuration.getMapperProxy(clazz,this);
    }

    public <T> T selectOne(String statementId,Object param){
        String sql= configuration.getValue(statementId);
        return (T)myExector.query(String.format(sql,param));
    }
}
