package Transaction;


import org.junit.jupiter.api.Test;
import util.JDBCUtils;


import java.sql.Connection;

public class ConnectionTest {
    @Test
    public void testConnection() throws Exception {
        Connection conn= JDBCUtils.getConnection();
        System.out.println(conn);

    }



}
