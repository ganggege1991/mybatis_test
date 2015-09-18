package com.testmybatis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

/**
 * 
 * 
 * @author hegang
 * @date 2015-09-17
 */
public class RedisJava {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println(jedis.ping());
	}
}
