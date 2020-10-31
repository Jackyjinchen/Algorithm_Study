package av64213436;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class spinlockdemo {

	AtomicReference<Thread> atr = new AtomicReference<Thread>();

	public void Lock() {
		Thread thread = Thread.currentThread();
		while (!atr.compareAndSet(null, thread)) {

		}

		System.out.println(Thread.currentThread().getName() + "Lock");

	}

	public void Unlock() {
		Thread thread = Thread.currentThread();
		atr.compareAndSet(thread, null);

		System.out.println(Thread.currentThread().getName() + "Unlock");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		spinlockdemo sp = new spinlockdemo();
		new Thread(() -> {
			sp.Lock();
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			sp.Unlock();
		}, "AAA").start();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(() -> {

			sp.Lock();
			sp.Unlock();
		}, "BBB").start();

	}

}
