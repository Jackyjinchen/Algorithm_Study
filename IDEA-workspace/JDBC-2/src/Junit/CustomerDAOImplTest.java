package Junit;

import Transaction.CustomerDAOImpl;
import bean.Customer;
import org.junit.jupiter.api.Test;
import util.DruidUtils;
import java.sql.Connection;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerDAOImplTest {
    private CustomerDAOImpl dao=new CustomerDAOImpl();
    @Test
    public void insert() {
        Connection conn= null;
        try {
            conn = DruidUtils.getConnection();
            Customer cust = new Customer(1, "李四", "abc@qq.com", new Date(123123123));
            dao.insert(conn,cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeResource(conn,null);
        }

    }

    @Test
    void deleteByID() {
    }

    @Test
    void update() {
    }

    @Test
    void getByID() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getCount() {
    }

    @Test
    void getMaxBirth() {
    }
}