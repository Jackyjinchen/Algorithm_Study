import redis.clients.jedis.Jedis;

import java.util.Set;

public class TestAPI {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.184.128",6379);
//        jedis.set("k6","v6");
//        System.out.println(jedis.get("k3"));
        Set<String> sets=jedis.keys("*");
        System.out.println(sets.toString());

    }

}
