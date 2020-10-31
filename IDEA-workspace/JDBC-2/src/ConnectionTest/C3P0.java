package ConnectionTest;

import com.mchange.v2.c3p0.*;
import org.junit.jupiter.api.Test;


import java.sql.Connection;


public class C3P0 {

    public void testGetConnection() throws Exception {
        //获取c3p0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=Asia/Shanghai" );
        cpds.setUser("root");
        cpds.setPassword("123456");
        //设置相关参数，对数据库连接池进行管理
        //连接池中的连接数量
        cpds.setInitialPoolSize(10);
        Connection conn=cpds.getConnection();
        System.out.println(conn);
    }
    @Test
    public void testGetConnection2() throws Exception {
        //获取c3p0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection conn=cpds.getConnection();
        System.out.println(conn);

    }


}
