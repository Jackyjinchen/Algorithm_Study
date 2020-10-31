package testdemo;

import AopAnno.User;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopAnno {

    @Test
    public void testaopano(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        User user = context.getBean("user", User.class);
        System.out.println("完事儿了");
        user.add();
    }


}
