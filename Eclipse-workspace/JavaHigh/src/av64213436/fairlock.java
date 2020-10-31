package av64213436;

import java.util.concurrent.locks.ReentrantLock;

public class fairlock {

	static int a = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReentrantLock lock = new ReentrantLock();

		for (int i = 0; i < 100; i++) {

			new Thread(() -> {

				try {
					lock.lock();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
					for (int j = 0; j < 10; j++) {
						a++;
						System.out.println(a+"now is"+Thread.currentThread().getName());
					}

				} finally {
					lock.unlock();
				}

			}, String.valueOf(i)).start();

		}

	}

}
