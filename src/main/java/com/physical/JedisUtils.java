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
	
	/**
	 * 关闭连接
	 * @param jedis
	 */
	public static void closeJedis(Jedis jedis) {
		jedis.close();
		pool.close();
	}
	
	/**
	 * 传入对象最为键值对
	 * @param key
	 * @param value
	 */
	public static void append(byte[] key,Object value) {
		Jedis jedis = openJedis();
		byte[] b = SerializeUtil.serialize(value);
		jedis.append(key, b);
		closeJedis(jedis);
	}
	
	/**
	 * 传入字符串作为键值对
	 * @param key
	 * @param value
	 */
	public static void append(String key,String value) {
		Jedis jedis = openJedis();
		jedis.append(key, value);
		closeJedis(jedis);
	}
	
	/**
	 * 根据字符串key获取值
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		Jedis jedis = openJedis();
		String value = jedis.get(key);
		return value;
	}
	
	/**
	 * 根据对象key查找
	 * @param key
	 * @return
	 */
	public static Object getValue(byte[] key) {
		Jedis jedis = openJedis();
		byte[] b = jedis.get(key);
		Object o = SerializeUtil.unserialize(b);
		return o;
	}
	
	/**
	 * 删除
	 * @param key
	 */
	public static void remove(String key) {
		Jedis jedis = openJedis();
		jedis.del(key);
	}
	
	/**
	 * 删除
	 * @param key
	 */
	public static void remove(byte[] key) {
		Jedis jedis = openJedis();
		jedis.del(key);
	}
	
	public static void main(String[] args) {
		RedisTest test = new RedisTest();
		test.setName("小明");
		test.setAge("22");
		test.setHeight("177");
		test.setWeight("74.7");
		
		append("sunxu".getBytes(), test);
		RedisTest aa = new RedisTest();
		aa = (RedisTest) getValue("sunxu".getBytes());
		
		JSONObject json = (JSONObject) JSONObject.toJSON(aa);
		System.out.println(json.toJSONString());
		
		remove("sunxu".getBytes());
	}
}
