package Transaction;

import bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public interface CustomerDAO {

    //增删改查服务接口
    void insert(Connection conn, Customer cust);//增

    void deleteByID(Connection conn, int id);//删

    void update(Connection conn, Customer customer);//改

    Customer getByID(Connection conn, int id);//查

    List<Customer> getAll(Connection conn);//打印全表

    Long getCount(Connection conn);//返回条目数

    Date getMaxBirth(Connection conn);

}
