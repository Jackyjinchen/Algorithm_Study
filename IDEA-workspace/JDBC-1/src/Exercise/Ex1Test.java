package Exercise;

import org.junit.jupiter.api.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Ex1Test {

    public static void main(String args[]) {

        Ex1Test ex1Test = new Ex1Test();
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入用户名");
        String name = scanner.next();
        System.out.println("输入邮箱");
        String email = scanner.next();
        System.out.println("输入生日");
        String birthday = scanner.next();
        String sql = "insert into customers(name,email,birth)values(?,?,?)";

        int insertCount=ex1Test.update(sql, name, email, birthday);
        if (insertCount>0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }

    }


    public int update(String sql, Object... args) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            /*
            ps.execute();
            如果执行查询操作，有返回结果，则方法返回tintrue
            如果执行增删改操作，没有返回结果，则方法返回false
             */
//            ps.execute();
//            采用此操作有int型返回值，DML操作影响的行数
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
        return 0;

    }


}
