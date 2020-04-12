package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 这个类用于测试删除数据库中的表的操作,也是DDl语言.
 * 同样使用的是execute方法来执行SQL语句
 */
public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. 注册驱动.
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 获取连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/newdb3?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai",
                "root",
                "root");
        //3. 创建执行对象
        Statement s = conn.createStatement();
        //4. 执行Sql语句
        String sql = "drop table jdbct1";
        s.execute(sql);
        System.out.println("执行完毕...");
        //5. 关闭资源
        conn.close();
    }
}
