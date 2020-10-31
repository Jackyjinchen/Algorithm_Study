package BlobTest;

import org.junit.jupiter.api.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

//批量操作update、delete本身就具有批量操作效果
//需要采用PreparedStatement实现高效批量插入insert
//向goods插入20000条数据

public class InsertMTest {

    //采用addBatch操作
    //默认Mysql不支持，需要开启，在url后加入?rewriteBatchedStatements=true?useUnicode=true&characterEncoding=utf-8
    @Test
    public void insertMTest2() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();

            //设置不允许自动提交数据
            conn.setAutoCommit(false);

            String sql = "insert into goods(name)values(?)";

            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 20000; i++) {
                ps.setObject(1, "name_" + i);
                ps.addBatch();
                if (i % 500 == 0) {
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }

            conn.commit();
        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }

    }


    //采用for循环批量操作
    public void insertMTest() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into goods(name)values(?)";

            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 20000; i++) {
                ps.setObject(1, "name_" + i);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }


}
