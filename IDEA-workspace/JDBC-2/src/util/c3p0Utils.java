package util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 操作数据库的工具类
 */
public class c3p0Utils {
    //c3p0数据库连接池静态，使用时仅获取连接
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
    //获取数据库连接
    public static Connection getConnection() throws  Exception{

        Connection conn=cpds.getConnection();

        return conn;
    }

    public static void closeResource(Connection conn, PreparedStatement ps){
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //关闭资源操作
    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (rs != null)
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
