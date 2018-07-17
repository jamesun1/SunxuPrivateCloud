package com.physical;

import com.alibaba.fastjson.JSONObject;
import com.physical.model.Userinfo;
import com.physical.util.SerializeUtil;
import com.physical.vo.RedisTest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {

	private static JedisPool pool = null;
	
	
	/**
	 * 打开Jedis连接
	 */
	public static Jedis openJedis() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		// 设置最大10个连接
		jedisPoolConfig.setMaxTotal(10);
		pool = new JedisPool(jedisPoolConfig, "119.29.108.164",6379,2000,"sunxu");
		Jedis jedis = pool.getResource();
		return jedis;
	}
	
	public static void closeJedis(Jedis jedis) {
		jedis.close();
		pool.close();
	}
	
	public static void append(byte[] key,Object value) {
		Jedis jedis = openJedis();
		byte[] b = SerializeUtil.serialize(value);
		jedis.append(key, b);
		closeJedis(jedis);
	}
	
	public static void append(String key,String value) {
		Jedis jedis = openJedis();
		jedis.append(key, value);
		closeJedis(jedis);
	}
	
	public static String getValue(String key) {
		Jedis jedis = openJedis();
		String value = jedis.get(key);
		return value;
	}
	
	public static Object getValue(byte[] key) {
		Jedis jedis = openJedis();
		byte[] b = jedis.get(key);
		Object o = SerializeUtil.unserialize(b);
		return o;
	}
	
	public static void main(String[] args) {
		RedisTest test = new RedisTest();
		test.setName("孙旭");
		test.setAge("22");
		test.setHeight("177");
		test.setWeight("74.7");
		
		append("sunxu".getBytes(), test);
		RedisTest aa = new RedisTest();
		aa = (RedisTest) getValue("sunxu".getBytes());
		
		JSONObject json = (JSONObject) JSONObject.toJSON(aa);
		System.out.println(json.toJSONString());
	}
}
