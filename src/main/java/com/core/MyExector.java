package com.core;

import com.dao.domain.UserDO;

import java.sql.*;

public class MyExector {

    public <T> T query(String sql){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet =null;
        UserDO userDO = new UserDO();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatistest","root","");
            statement = connection.createStatement();
             resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                userDO.setId(resultSet.getLong(1));
                userDO.setName(resultSet.getString(2));
                userDO.setAddress(resultSet.getString(3));

            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return (T) userDO;

    }
}
