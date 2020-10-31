package JDBCconnection;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {

    public static void main(String[] args) {

    }

    //方式一，采用MySQL提供的重写的Driver()驱动
    public void testConnection1() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();
//        JDBC URL形式：jdbc：子协议：子名称
//        此处需要解决中文编码问题，加入 ?useUnicode=true&characterEncoding=utf8 即可解决
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");
        Connection conn = driver.connect(url, info);

        System.out.println(conn);

    }

    //方式二，采用反射，不出现第三方API，使程序具有更好可移植性
    public void testConnection2() throws Exception {
//        反射实现Driver类对象获取
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
//        Java9之后推荐采用.getDeclaredConstructor().newInstance()，之前采用.newInstance()
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");
        Connection conn = driver.connect(url, info);

    }

    //方式三，采用DriverManager替换Driver
    public void testConnection3() throws Exception {
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
//        Java9之后推荐采用.getDeclaredConstructor().newInstance()，之前采用.newInstance()
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();
        DriverManager.registerDriver(driver);

        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
        String user = "root";
        String password = "123456";

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }

    //方式四，MySQL自行采用静态代码块进行了注册
    public void testConnection4() throws Exception {
//        MySQL自动执行了Driver注册
//        在引入Libraries时，MySQL自动将Driver类引入了 /META-INF/services/java.sql.Driver
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
        String user = "root";
        String password = "123456";

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }

    //方式五，将配置信息写入文件，而不是写入程序
    //1、代码数据分离，实现解耦
    //2、实现打包后依旧可以修改程序参数

    public void testConnection5() throws Exception {

//        配置信息
//        Class.forName("com.mysql.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
//        String user = "root";
//        String password = "123456";
        InputStream is =ConnectionTest.class.getClassLoader().getResourceAsStream("JDBC.properties");
        Properties pros=new Properties();
        pros.load(is);
        String user=pros.getProperty("user");
        String password=pros.getProperty("password");
        String url=pros.getProperty("url");
        String driverClass=pros.getProperty("driverClass");
        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }



}
