package av64213436;

import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(1, 1);
		
		asr.compareAndSet(1, 2, 1, 5);
		System.out.println(asr.getReference());
		
		asr.compareAndSet(2, 3, 4, 7);
		System.out.println(asr.getReference());
		
		asr.compareAndSet(5, 3, 5, 7);
		System.out.println(asr.getReference());
		
		asr.compareAndSet(2, 3, 5, 7);
		System.out.println(asr.getReference());
		
		
		
	}

}
