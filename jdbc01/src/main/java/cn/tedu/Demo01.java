package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测类演示的是:
 * 使用JDBC技术来连接数据库,并在数据库中创建了表.
 * 也就是执行了数据库相关的DDl语言
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 获取连接对象
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/newdb3?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai",
                "root",
                "root");
        System.out.println(conn);//如果成功的连接数据库了,就会控制台看到连接对象的引用地址.
        //3. 通过连接对象conn来创建执行SQL语句的对象
        Statement statement = conn.createStatement();
        //4. 执行SQL语句
        String sql = "create table emp(empno int, ename varchar(10))";
        statement.execute(sql);
        System.out.println("执行完成...");
        //5. 释放资源
        conn.close();
    }
}
