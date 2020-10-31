package Callable;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class reentrantlockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reentrant ticket=new reentrant();
		new Thread(ticket, "1号窗口").start();
		new Thread(ticket, "2号窗口").start();
		new Thread(ticket, "3号窗口").start();
		new Thread(ticket, "4号窗口").start();
		
		
		

	}

}

class reentrant implements Runnable {

	private int tick = 100;
	private Lock lock = new ReentrantLock();

	@Override
	public void run() {

		while (true) {
			lock.lock();
			try {
				if (tick > 0) {
					try {
						Thread.sleep(2);
					} catch (InterruptedException e) {

					}
					System.out.println(Thread.currentThread().getName() + "完成售票，余票为：" + --tick);
				}

			} finally {
				lock.unlock();
			}

		}

	}

}
