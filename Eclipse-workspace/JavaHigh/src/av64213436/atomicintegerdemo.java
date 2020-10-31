package av64213436;

import java.util.concurrent.atomic.AtomicInteger;

public class atomicintegerdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicInteger at = new AtomicInteger(5);
		
		System.out.println(at.compareAndExchange(5, 7) + "\t current data"+at.get());
		System.out.println(at.compareAndExchange(5, 8) + "\t current data"+at.get());
		
		
		
		
	}

}

