package Callable;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class reentrantlockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reentrant ticket=new reentrant();
		new Thread(ticket, "1�Ŵ���").start();
		new Thread(ticket, "2�Ŵ���").start();
		new Thread(ticket, "3�Ŵ���").start();
		new Thread(ticket, "4�Ŵ���").start();
		
		
		

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
					System.out.println(Thread.currentThread().getName() + "�����Ʊ����ƱΪ��" + --tick);
				}

			} finally {
				lock.unlock();
			}

		}

	}

}
