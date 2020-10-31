package BlobTest;


import bean.Customer;
import org.junit.jupiter.api.Test;
import util.JDBCUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.concurrent.BlockingQueue;

/**
 * 使用PreparedStatement操作Blob类型数据
 */
public class blobTest {
    @Test
    public void insertBlob() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1, "Alise");
        ps.setObject(2, "zhang@qq.com");
        ps.setObject(3, "1900-01-01");

        FileInputStream is = new FileInputStream(new File("F:\\Desktop\\pic.jpg"));

        ps.setBlob(4, is);
        ps.execute();

        JDBCUtils.closeResource(conn, ps);


    }

    @Test
    public void outputBlob() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        InputStream is = null;
        FileOutputStream fos = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth,photo from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 21);
            rs = ps.executeQuery();

//        FileInputStream is=new FileInputStream(new File("F:\\Desktop\\pic.jpg"));

            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                Date birth = rs.getDate(4);
                Customer customer = new Customer(id, name, email, birth);

                //            FileOutputStream os=new FileOutputStream("F:\\Desktop\\test.jpg");
                //            os.write(rs.getBytes(5));

                Blob photo = rs.getBlob(5);
                is = photo.getBinaryStream();
                fos = new FileOutputStream("F:\\Desktop\\test.jpg");
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            is.close();
            fos.close();
            JDBCUtils.closeResource(conn, ps, rs);
        }


    }


}
