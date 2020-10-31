package Callable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class _线程同步锁 {

	private static class AtomicSynchronizedExample {
	    private volatile int cnt = 0;
//	    private AtomicInteger  cnt = new AtomicInteger(0);

	    //同步操作synchronized锁
	    public synchronized void add() {
	    	cnt++;
	    }
//	        cnt.getAndIncrement();
//	    synchronized
	    public synchronized int get() {
	        return cnt;
	    }
	}
	public static void main(String[] args) throws InterruptedException {
		
//		ThreadLocal local = new ThreadLocal();
//		local.set(1);
		
	    final int threadSize = 100000;
	    AtomicSynchronizedExample example = new AtomicSynchronizedExample();
	    final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
	    ExecutorService executorService = Executors.newCachedThreadPool();
	    for (int i = 0; i < threadSize; i++) {
	        executorService.execute(() -> {
	            example.add();
	            countDownLatch.countDown();
	        });
	    }
	    countDownLatch.await();
	    executorService.shutdown();
	    System.out.println(example.get());
	}

}
