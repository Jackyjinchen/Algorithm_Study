package PreparedStatement.crud;

import bean.Customer;
import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * 针对Customers表的通用查询操作查询操作
 */
public class CustomerForQuery {
    //?useUnicode=true&characterEncoding=utf-8
    public static void main(String[] args) {
        CustomerForQuery query = new CustomerForQuery();
        String sql="select id,name,birth,email from customers where id = ?";
        Customer customer=query.queryForCustomers(sql,1);
        System.out.println(customer);

        String sql1="select id,name,birth,email from customers where name = ?";
        Customer customer1=query.queryForCustomers(sql,"汪峰");
        System.out.println(customer1);

    }

    public Customer queryForCustomers(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                Customer customer = new Customer();
                for (int i = 0; i < columnCount; i++) {
                    Object columnvalue = rs.getObject(i + 1);

                    //给Customer的指定属性赋值为value
                    String columnName = rsmd.getColumnName(i + 1);
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(customer, columnvalue);
                }
                return customer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }

        return null;
    }


    public void testQuery1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 2);

            ps.executeQuery();
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                //获取当前数据各个字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date date = resultSet.getDate(4);

                //            Object[] table=new Object[]{id,name,email,date};
                //            System.out.println(Arrays.toString(table));
                //封装对象
                Customer customer = new Customer(id, name, email, date);
                System.out.println(customer);


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, resultSet);
        }


    }
}
