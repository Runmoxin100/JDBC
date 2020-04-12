package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试从数据库连接池中获取连接对象是否成功
 */
public class Demo {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConn()){
            Statement s = conn.createStatement();
            ResultSet rs =  s.executeQuery("select * from emp ");
            while (rs.next()){
                String ename = rs.getString("ename");
                int empno = rs.getInt("empno");
                System.out.println("empno:"+empno+",ename:"+ename);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
