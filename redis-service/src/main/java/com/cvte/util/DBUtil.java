package com.cvte.util;

import java.sql.*;

public class DBUtil {

    public static final String DBURL = "jdbc:mysql://172.18.81.146:3306/leejh_test1";
    public static final String USERNAME = "leejh";
    public static final String PASSWD = "leejh2017";

    private static volatile Connection con;

    /**
     * 获得Connection
     *
     * @return
     */
    public static Connection getConnection() {

        if (con == null) {
            try {
                synchronized (Connection.class) {
                    if (con == null) {
                        Class.forName("com.mysql.jdbc.Driver");//
                        con = DriverManager.getConnection(DBURL, USERNAME, PASSWD);
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }



    public static void closeAll(ResultSet rs , Statement stmt){
        try {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
