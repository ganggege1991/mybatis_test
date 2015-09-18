package com.testmybatis;

import java.util.HashMap;

import redis.clients.jedis.Jedis;

public class RedisStringJava {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.set("helloredis", "redis");
		System.out.println(jedis.get("helloredis"));
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("akey", "avlaue");
		
		/*Map*/
		jedis.hmset("a", map);
		map = (HashMap<String, String>) jedis.hgetAll("a");
		System.out.println(map);
	}
}
