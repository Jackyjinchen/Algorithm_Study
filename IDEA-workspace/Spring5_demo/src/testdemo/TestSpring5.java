package testdemo;

import ComponentTest.TestService;
import com.jacky.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {

    @Test
    public void testAdd(){
        //加载配置
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean1.xml");
        //获取对象
        User user = context.getBean("user", User.class);

        System.out.println(user);
        user.add();
        
    }

    @Test
    public void Test1(){
        ApplicationContext context
                =new ClassPathXmlApplicationContext("bean2.xml");
        TestService testService=context.getBean("testService",TestService.class);
        System.out.println(testService);
        testService.add();
    }
}

