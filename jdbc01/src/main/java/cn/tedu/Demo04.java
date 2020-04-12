package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo04 {
    public static void main(String[] args) {
        try (Connection connection = DBUtils.getConn()){

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
