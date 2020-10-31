package leetcodeanswer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }
}
class Employee extends Person {
    String empID = "0000";
    public Employee(String id) {
    	super("13");
        empID = id;
    }
}
public class Main {
    public static void main(String args[]) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}