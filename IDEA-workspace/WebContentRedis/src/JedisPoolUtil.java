import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

class JedisPoolUtil{
    private static volatile JedisPool jedisPool=null;
    private JedisPoolUtil(){}

    public static JedisPool getJedisPoolInstance(){
        if(null==jedisPool){
            synchronized (JedisPoolUtil.class){
                if(null==jedisPool){
                    JedisPoolConfig poolConfig=new JedisPoolConfig();
                    //池化设置
                    poolConfig.setMaxTotal(1000);
                    poolConfig.setMaxIdle(32);
                    poolConfig.setMaxWaitMillis(100*1000);
                    poolConfig.setTestOnBorrow(true);


                    jedisPool=new JedisPool(poolConfig,"192.168.184.128",6379);
                }
            }
        }
        return  jedisPool;
    }




}