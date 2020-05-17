package com.main;

import com.core.Configuration;
import com.core.MyExector;
import com.core.MySqlSession;
import com.dao.mapper.UserDOMapper;

public class Main {
    public static void main(String[] args) {
        MySqlSession mySqlSession = new MySqlSession(new MyExector(),new Configuration());
        UserDOMapper mapper = mySqlSession.getMapper(UserDOMapper.class);
        System.out.println(mapper.selectOne(1L));

    }
}
