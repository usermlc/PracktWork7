package com.await.bdpw7.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
    public static Connection connect() {
        String url = "jdbc:sqlite:" + ConnectToDB.class.getResource("/db/data.sqlite").getPath();
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
