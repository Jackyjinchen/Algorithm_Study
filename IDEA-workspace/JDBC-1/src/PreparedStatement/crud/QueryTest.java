package PreparedStatement.crud;


import bean.Customer;
import bean.Order;
import org.junit.jupiter.api.Test;
import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

//使用PreparedStatement实现针对于不同表的通用查询操作
public class QueryTest {

    @Test
    public void testgetInstance(){
//
        String sql="select id,name,email from customers";
        List<Customer> c = getForList(Customer.class, sql);
        c.forEach(System.out::println);

        String sql1="select order_id orderId,order_name orderName from `order`";
        List<Order> c1 = getForList(Order.class, sql1);
        c1.forEach(System.out::println);
    }

    public <T> List<T> getForList(Class<T> clazz, String sql, Object... args){
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
            //创建集合
            ArrayList<T> list = new ArrayList<>();
            while (rs.next()) {
                //构建新对象
                T t = clazz.getDeclaredConstructor().newInstance();
                //Order order = new Order();
                //获取列值
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    //!!!!!!!!!!!此处用的是表的原名，加入sql语句修改了名字，不会有影响
                    //获取列的别名getColumnLabel();
                    //String columnName = rsmd.getColumnName(i + 1);
                    String columnName = rsmd.getColumnLabel(i + 1);

                    //通过反射将指定属性名属性赋值为给定的值
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnValue);

                }
                list.add(t);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;

    }





    /**
     * 仅获取一个对象，表只返回一个对象。
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    //泛型参数返回对应的Class类
    public <T> T getInstance(Class<T> clazz, String sql, Object... args) {
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
                //构建新对象
                T t = clazz.getDeclaredConstructor().newInstance();


                //Order order = new Order();
                //获取列值
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    //!!!!!!!!!!!此处用的是表的原名，加入sql语句修改了名字，不会有影响
                    //获取列的别名getColumnLabel();
                    //String columnName = rsmd.getColumnName(i + 1);
                    String columnName = rsmd.getColumnLabel(i + 1);

                    //通过反射将指定属性名属性赋值为给定的值
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnValue);

                }
                return t;

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;

    }

}
