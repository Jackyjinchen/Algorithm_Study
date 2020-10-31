package Exercise;

import bean.Student;
import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2Test {


    public static void main (String args[]){

        Ex2Test ex2Test = new Ex2Test();
        System.out.println("请选择您要输入的类型：");
        System.out.println("a.准考证号");
        System.out.println("b.身份证号");
        Scanner scanner = new Scanner(System.in);
        String sel = scanner.next();
        if ("a".equalsIgnoreCase(sel)){
            System.out.println("准考证号：");
            String examCard=scanner.next();
            String sql="select FlowID flowID,Type type,IDCard,ExamCard,StudentName studentName, Location location,Grade grade from examstudent where ExamCard = ?";
            Student student=ex2Test.getInstance(Student.class,sql,examCard);
            System.out.println(student);
        }else if("b".equalsIgnoreCase(sel)){
            System.out.println("身份证号：");
            String IDCard=scanner.next();
            String sql="select FlowID flowID,Type type,IDCard,ExamCard,StudentName studentName, Location location,Grade grade from examstudent where IDCard = ?";
            Student student=ex2Test.getInstance(Student.class,sql,IDCard);
            System.out.println(student);
        }else{
            System.out.println("您的输入有误，请重新进入程序。");
        }


    }

    public void queryTest(){
        ///////////////////////////////////
        ///////////////////////////////////
    }


//    插入操作
    public void insertTest(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("四级/六级：");
        int type = scanner.nextInt();
        System.out.println("身份证号：");
        String IDCard = scanner.next();
        System.out.println("准考证号：");
        String examCard = scanner.next();
        System.out.println("学生姓名：");
        String studentName = scanner.next();
        System.out.println("所在城市：");
        String location=scanner.next();
        System.out.println("考试成绩：");
        int grade =scanner.nextInt();


        String sql ="insert into examstudent(type,IDCard,examCard,studentName,location,grade)values(?,?,?,?,?,?)";
        int insertCount=update(sql,type,IDCard,examCard,studentName,location,grade);
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
