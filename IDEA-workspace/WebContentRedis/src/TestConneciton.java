import redis.clients.jedis.Jedis;

public class TestConneciton {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.184.128",6379);
        System.out.println(jedis.ping());
    }

}
