import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestPool {
    public static void main(String[] args) {

        JedisPool pool=JedisPoolUtil.getJedisPoolInstance();
        JedisPool pool2=JedisPoolUtil.getJedisPoolInstance();
        System.out.println(pool==pool2);
        Jedis jedis=null;
        try {
            jedis = pool.getResource();
            jedis.set("k99","v99");
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

}

