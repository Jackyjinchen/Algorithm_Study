package 生产消费者;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Resourcetest{
    BlockingQueue<Integer> blockingQueue=null;
    AtomicInteger atomicInteger=new AtomicInteger();
    boolean flag=true;

    public Resourcetest(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void prod(){

        while(flag){
            try {
                atomicInteger.incrementAndGet();
                blockingQueue.put(1);
                System.out.println(Thread.currentThread().getName()+"生产"+atomicInteger);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try{ TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}

        }
    }

    public void consumer(){

        while(flag){
            try {
                atomicInteger.decrementAndGet();
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName()+"取出"+atomicInteger);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try{ TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}

        }
    }



}


public class test {
    public static void main(String[] args) throws Exception{
        Resourcetest resourcetest=new Resourcetest(new ArrayBlockingQueue(3));
        new Thread(()->{
            resourcetest.prod();
        },"AA").start();

        new Thread(()->{
            resourcetest.consumer();
        },"BB").start();

    }



}
