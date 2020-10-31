import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTransaction {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.184.128",6379);

        jedis.watch("k4");
        Transaction transaction=jedis.multi();

        transaction.set("k4","v4");
        transaction.set("k5","v55");
//        transaction.discard();

        transaction.exec();



    }
}
