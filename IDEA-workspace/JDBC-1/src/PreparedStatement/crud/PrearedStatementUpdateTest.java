package PreparedStatement.crud;


import JDBCconnection.ConnectionTest;
import org.junit.jupiter.api.Test;
import util.JDBCUtils;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 利用PreparedStatement实现SQL增删改(无返回)、查(有返回)操作
 */
public class PrearedStatementUpdateTest {

    public static void main(String[] args) {
        PrearedStatementUpdateTest psut=new PrearedStatementUpdateTest();
//        String sql="delete from customers where id = ?";
//        psut.update(sql,20);
        //表名order是关键字，所以采用`order`解决 注意！！不是单引号
        String  sql="update `order` set order_name = ? where order_id = ?";
        psut.update(sql,"DD","2");


    }
    public void update(String sql, Object... args) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }


    //修改记录
    public void testUpdate() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //获取连接
            conn = JDBCUtils.getConnection();
            //编译SQL语句，返回PreparedStatement实例
            String sql = "update customers set name = ? where id = ?";
            ps = conn.prepareStatement(sql);
            //添加占位符
            ps.setString(1, "成凤");
            ps.setObject(2, 5);
            //执行
            ps.execute();
        } finally {
            //资源关闭
            JDBCUtils.closeResource(conn, ps);
        }


    }


    //添加数据

    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("JDBC.properties");
            Properties pros = new Properties();
            pros.load(is);
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
            //预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into customers(name,email,birth)values(?,?,?)";//?:占位符
            ps = conn.prepareStatement(sql);
            //填充占位符
            ps.setString(1, "哪吒");
            ps.setString(2, "nezha@gmail.com");
//            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//            Date date=sdf.parse("1000-01-01");
            ps.setString(3, "1111-09-09");

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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


    }


}
