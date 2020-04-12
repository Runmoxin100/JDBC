package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    public static Connection getConn() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/newdb3?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai",
                "root",
                "root");
        return conn;
    }
}
