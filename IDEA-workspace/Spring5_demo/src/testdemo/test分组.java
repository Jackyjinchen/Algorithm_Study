package testdemo;

import org.junit.Test;

public class test分组 {

    @Test
    public void testfen() {
        for (int i = 1; i <300 ; i=i+16) {
            System.out.println(i+"到"+(i+15));


        }
    }
}
