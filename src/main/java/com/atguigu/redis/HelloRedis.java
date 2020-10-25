package com.atguigu.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class HelloRedis {


    private static final String HOST = "192.168.199.129";
    private static final int PORT=6379;


    public static void main(String[] args) throws InterruptedException {

        Jedis jedis = new Jedis(HOST, PORT);
        String result = jedis.ping();
        System.out.println(result);

        jedis.set("k1", "v1");
        jedis.set("k2", "v1");
        jedis.set("k3", "v1");
        String v1 = jedis.get("k1");
        System.out.println("valu:"+v1);


        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

        jedis.expire("k1", 10);
        int i=1;

        while (jedis.exists("k1")){
            Thread.sleep(1000);
            System.out.println(i++);
        }


        jedis.close();
    }



}
