package cn.tedu;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 这个类是一个从数据库连接池中获取连接对象的工具类
 */
public class DBUtils {

    private static BasicDataSource ds ;
    //写到静态块里是为了让读取配置文件的代码和创建连接池的代码只执行一次
    static {
        //1. 创建Properties对象
        Properties properties = new Properties();
        //2. 通过反射来获取该工具类的类对象,在通过类对象调用方法获取输入流并读取配置文件
        InputStream inputStream =
                DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        //3. 将得到的输入流加载到properties对象中
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4. 从properties对象中获取配置文件中的Key的值
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        //5. 注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //6. 创建一个数据库连接池对象
        ds = new BasicDataSource();
        //7. 设置数据库连接池
        ds.setUsername(username);
        ds.setUrl(url);
        ds.setPassword(password);
        ds.setInitialSize(2);
        ds.setMaxActive(5);
    }

    /**
     * 从数据库连接池中获取连接对象
     * @return 返回连接对象
     * @throws SQLException
     */
    public static Connection getConn() throws SQLException {
        return ds.getConnection();
    }

}
