package AopAnno;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserProxy {

    @After(value = "execution(* AopAnno.User.add(..))")
    public void before(){
        System.out.println("在前面先操作。。。");
    }

}
