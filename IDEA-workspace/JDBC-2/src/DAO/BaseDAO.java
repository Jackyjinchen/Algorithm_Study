package DAO;


import org.junit.jupiter.api.parallel.ResourceLock;
import util.JDBCUtils;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/***
 * 封装DAO操作
 * 1.update(Connection conn, String sql, Object... args) 增删改
 * 2.getForList(Connection conn, Class<T> clazz, String sql, Object... args) 返回List查
 * 3.getInstance(Connection conn, Class<T> clazz, String sql, Object... args)返回Object查
 * 4.getValue(Connection conn, String sql, Object... args)获得处理值，如Count(*)
 */


/**
 * 封装数据表的通用操作增删改查
 */
public class BaseDAO {

    public void update(Connection conn, String sql, Object... args) {

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps);
        }
    }

    public <T> List<T> getForList(Connection conn, Class<T> clazz, String sql, Object... args) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
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
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;

    }


    /**
     * 仅获取一个对象，表只返回一个对象。
     *
     * @param clazz 类对应数据表
     * @param sql   SQL语句
     * @param args  SQL语句参数
     * @param <T>   返回表List
     * @return
     */
    //泛型参数返回对应的Class类
    public <T> T getInstance(Connection conn, Class<T> clazz, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
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
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;

    }

    public <E> E getValue(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            if (rs.next()) {
                return (E) rs.getObject(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }


}
