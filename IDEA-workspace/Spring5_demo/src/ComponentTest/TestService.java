
package ComponentTest;


import org.springframework.stereotype.Component;

@Component(value = "testService")
public class TestService {
    public void add(){
        System.out.println("add........");
    }
}
