package ConnectionTest;

import bean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;
import util.DruidUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DButilsTest {

    public void testInsert() throws Exception {
        Connection conn = null;
        try {
            QueryRunner runner=new QueryRunner();
            conn = DruidUtils.getConnection();
            String sql="insert into customers(name,email,birth)values(?,?,?)";

            int insertCount=runner.update(conn,sql,"蔡徐坤","caibi@shabi.com","1900-01-01");
            System.out.println("添加了"+insertCount+"条记录");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeResource(conn,null);
        }
    }

    public void testQuery() throws Exception {
        Connection conn = null;
        try {
            QueryRunner runner=new QueryRunner();
            conn = DruidUtils.getConnection();
            String sql="select id,name,email,birth from customers where id = ?";
            //ResultSetHandler接口实现类BeanHandler，用于封装表中的一条记录
            BeanHandler<Customer> beanHandler=new BeanHandler<>(Customer.class);
            Customer customer=runner.query(conn,sql,beanHandler,19);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeResource(conn,null);
        }
    }

    //多条记录
    public void testQuery2() throws Exception {
        Connection conn = null;
        try {
            QueryRunner runner=new QueryRunner();
            conn = DruidUtils.getConnection();
            String sql="select id,name,email,birth from customers ";
            //ResultSetHandler接口实现类BeanListHandler，用于封装表中的多条记录
            BeanListHandler<Customer> beanHandler=new BeanListHandler<>(Customer.class);
            List<Customer> customer=runner.query(conn,sql,beanHandler);
            customer.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeResource(conn,null);
        }
    }


    /**
     * 用于查询特殊值 如count max 等
     */
    public void testValue() throws Exception {
        Connection conn = null;
        try {
            QueryRunner runner=new QueryRunner();
            conn = DruidUtils.getConnection();
            String sql="select count(*) from customers ";
            //ResultSetHandler接口实现类BeanListHandler，用于封装表中的多条记录
            ScalarHandler scalarHandler=new ScalarHandler();
            Long query = (Long) runner.query(conn, sql, scalarHandler);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeResource(conn,null);
        }
    }

    @Test
    /**
     * 自定义ResultSetHandler实现类
     */
    public void handler() throws Exception {
        Connection conn = null;
        try {
            QueryRunner runner=new QueryRunner();
            conn = DruidUtils.getConnection();
            String sql="select count(*) from customers ";
            //ResultSetHandler接口实现类BeanListHandler，用于封装表中的多条记录
            ResultSetHandler<Customer> resultSetHandler=new ResultSetHandler<Customer>() {
                @Override
                public Customer handle(ResultSet resultSet) throws SQLException {
                    return new Customer(12,"123","jdre",new Date(123214));
                }
            };

            Customer customer= runner.query(conn, sql, resultSetHandler);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeResource(conn,null);
        }
    }





}
