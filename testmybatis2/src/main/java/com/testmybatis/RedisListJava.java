package com.testmybatis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisListJava {
	public static void main(String[] args) {
		  //���ӱ��ص� Redis ����
	      Jedis jedis = new Jedis("localhost");
	      jedis.lpush("helloredis3", "rdis1");
	      jedis.lpush("helloredis3", "rdis2");
	      List<String> list = jedis.lrange("helloredis3", 0, 1);
	      
	      System.out.println(list);
	}
}
