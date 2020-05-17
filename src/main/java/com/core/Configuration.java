package com.core;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

public class Configuration {

    private static  final ResourceBundle bunble;
    static {
        bunble = ResourceBundle.getBundle("sqlmapper");
    }

    public  String getValue(String key){
        return bunble.getString(key);
    }

    public <T>T getMapperProxy(Class clazz,MySqlSession mySqlSession){
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new MyProxy(mySqlSession));
    }
}
