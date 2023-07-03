package com.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHelper {

    // 静态代码
    private static String cname = "com.mysql.jdbc.Driver";
    private static String uname = "root";
    private static String upwd = "123456";
    private static String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&serverTimezone=Asia/Shanghai";

    /**
     * 静态驱动
     */
    static {
        try {
            // 创建驱动
            Class.forName(cname);
        } catch (Exception e) {
            // 处理异常
            e.printStackTrace();
        }
    }

    /**
     * 静态连接
     *
     * @return 连接
     */
    public static Connection getCon() {
        // 定义连接
        Connection con = null;
        try {
            // 连接驱动
            con = DriverManager.getConnection(url, uname, upwd);
        } catch (Exception e) {
            // 处理异常
            e.printStackTrace();
        }
        // 返回连接
        return con;
    }

    /**
     * 关闭连接
     *
     * @param con 连接
     * @param ps  执行对象
     * @param rs  结果集
     */
    public static void getClose(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (con != null) {// 关闭连接
                con.close();
            }
            if (ps != null) {// 关闭执行对象
                ps.close();
            }
            if (rs != null) {// 关闭结果集
                rs.close();
            }
        } catch (Exception e) {
            // 处理异常
            e.printStackTrace();
        }
    }
}
