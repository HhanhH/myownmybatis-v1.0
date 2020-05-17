package com.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements InvocationHandler {
    private MySqlSession mySqlSession;

    public MyProxy(MySqlSession mySqlSession) {
        this.mySqlSession = mySqlSession;
    }

    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        String statementId = method.getDeclaringClass().getName()+"."+method.getName();
        return mySqlSession.selectOne(statementId,objects[0]);
    }
}
