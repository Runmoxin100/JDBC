package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试获取连接,使用的是封装的获取连接的方法
 */
public class Demo03 {
    public static void main(String[] args) {
        try (Connection connection = DBUtils.getConn()){
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("select * from emp  ");
            while (rs.next()){
                String ename = rs.getString("ename");
                System.out.println("ename: "+ename);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
