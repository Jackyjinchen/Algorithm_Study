package ConnectionTest;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCP {

    public void testConnetiondbcp() throws SQLException {
        //DBCP提供BasicDataSource
        BasicDataSource source=new BasicDataSource();

        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUrl("jdbc:mysql:///test");
        source.setUsername("root");
        source.setPassword("123456");
        //基本信息
        source.setInitialSize(10);
        source.setMaxActive(10);

        Connection conn=source.getConnection();
        System.out.println(conn);
    }
    @Test
    //配置文件
    public void testConnetiondbcp2() throws Exception {
        //DBCP提供BasicDataSource
//        InputStream is=ClassLoader.getSystemClassLoader().getSystemResourceAsStream("DBCP.properties");
        FileInputStream is =new FileInputStream(new File("src/DBCP.properties"));
        Properties pros=new Properties();
        pros.load(is);
        DataSource source=BasicDataSourceFactory.createDataSource(pros);
    }

}
