package com.testmybatis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisKeyJava {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1");
		Set<String> list = jedis.keys("*");
		System.out.println(list);
	}
}
