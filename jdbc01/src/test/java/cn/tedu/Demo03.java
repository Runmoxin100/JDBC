package cn.tedu;

import org.junit.Test;

import java.sql.*;

public class Demo03 {
    @Test
    public void insert() throws SQLException {
        System.out.println("插入数据");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?serverTimezone=Asia/Shanghai",
                "root", "root");
        Statement s = connection.createStatement();
        String sql = "insert into emp (empno, ename) values(4, 'String')";
        s.executeUpdate(sql);
        System.out.println("执行完成...");
        connection.close();
    }

    @Test
    public void delete() throws SQLException {
        System.out.println("删除数据");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?serverTimezone=Asia/Shanghai",
                "root", "root");
        Statement s = connection.createStatement();
        String sql = "delete from emp where empno = 4";
        s.executeUpdate(sql);
        System.out.println("执行完成...");
        connection.close();
    }

    @Test
    public void update() throws SQLException {
        System.out.println("更新数据");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?serverTimezone=Asia/Shanghai",
                "root", "root");
        Statement s = connection.createStatement();
        String sql = "update emp set ename = 'zhangsan' where empno=3";
        s.executeUpdate(sql);
        System.out.println("执行完成...");
        connection.close();
    }

    @Test
    public void select() throws SQLException {
        System.out.println("查找数据");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?serverTimezone=Asia/Shanghai",
                "root", "root");
        Statement s = connection.createStatement();
        String sql = "select * from emp";
        //执行查询操作,查询的结果放在ResultSet结果集当中
        ResultSet rs = s.executeQuery(sql);
        //遍历结果集中的数据
        while(rs.next()){
            int empno = rs.getInt("empno");
            String ename = rs.getString("ename");
            System.out.println("empno: "+empno+",ename: "+ename);
        }
    }

}
