package PreparedStatement.crud;

import bean.Order;
import org.junit.jupiter.api.Test;
import util.JDBCUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;

public class OrderForQuery {
@Test
    public void testorderForquery() throws Exception {
        String sql="select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
        Order order=orderForQuery(sql,1);
        System.out.println(order);

    }



    public Order orderForQuery(String sql, Object... args) throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            //执行语句
            rs = ps.executeQuery();
            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                Order order = new Order();
                //获取列值
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    //!!!!!!!!!!!此处用的是表的原名，加入sql语句修改了名字，不会有影响
                    //获取列的别名getColumnLabel();
                    //String columnName = rsmd.getColumnName(i + 1);
                    String columnName = rsmd.getColumnLabel(i + 1);

                    //通过反射将指定属性名属性赋值为给定的值
                    Field field = Order.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(order,columnValue);

                }
                return order;

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
    return null;

    }


    public void testQuery1() throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select order_id,order_name,order_date from `order` where order_id = ?";
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            if (rs.next()) {
                int id = (int) rs.getObject(1);
                String name = (String) rs.getObject(2);
                Date date = (Date) rs.getObject(3);
                Order order = new Order(id, name, date);
                System.out.println(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }


    }


}
