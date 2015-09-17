package com.testmybatis;

import redis.clients.jedis.Jedis;

public class RedisStringJava {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.set("helloredis", "redis");
		System.out.println(jedis.get("helloredis"));
	}
}
