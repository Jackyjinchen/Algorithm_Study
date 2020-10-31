package Callable;

public class ProductandConsumer {

	public static void main(String[] args) {
		Clerk clerk=new Clerk();
		
		Productor pro=new Productor(clerk);
		Consumer cus=new Consumer(clerk);
		
		new Thread(pro,"������").start();
		new Thread(cus,"������").start();
		
	
	}

}

//��Ա
class Clerk {

	private int product = 0;

	public synchronized void get() {
		if (product >= 10) {
			System.out.println("��Ʒ����");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println(Thread.currentThread().getName() + ":" + ++product);
			this.notifyAll();
		}
	}

	public synchronized void sale() {
		if (product <= 0) {
			System.out.println("ȱ��");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName() + ":" + --product);
			this.notifyAll();
		}
	}

}

class Productor implements Runnable {

	private Clerk clerk;

	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			clerk.get();
		}
	}

}

class Consumer implements Runnable {

	private Clerk clerk;

	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			clerk.sale();
		}
	}

}
