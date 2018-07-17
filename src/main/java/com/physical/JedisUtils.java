package com.physical;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.physical.util.SerializeUtil;
import com.physical.vo.RedisTest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {

	private static JedisPool pool = null;
	static InputStream inStream = JedisUtils.class.getClassLoader().getResourceAsStream("redis.properties");

	/**
	 * 打开Jedis连接
	 * 
	 * @throws IOException
	 */
	public static Jedis openJedis() throws IOException {
		Properties prop = new Properties();
		prop.load(inStream);
		String host = prop.getProperty("redis.host");
		String password = prop.getProperty("redis.password");
		String port = prop.getProperty("redis.port");
		String timeout = prop.getProperty("redis.timeout");
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		// 设置最大10个连接
		jedisPoolConfig.setMaxTotal(10);
		pool = new JedisPool(jedisPoolConfig, host, Integer.valueOf(port.toString()), Integer.valueOf(timeout), password);
		Jedis jedis = pool.getResource();
		return jedis;
	}

	/**
	 * 关闭连接
	 * 
	 * @param jedis
	 */
	public static void closeJedis(Jedis jedis) {
		jedis.close();
		pool.close();
	}

	/**
	 * 传入对象最为键值对
	 * 
	 * @param key
	 * @param value
	 */
	public static void append(byte[] key, Object value) {
		try {
			Jedis jedis = openJedis();
			byte[] b = SerializeUtil.serialize(value);
			jedis.append(key, b);
			closeJedis(jedis);
		} catch (Exception e) {

		}

	}

	/**
	 * 传入字符串作为键值对
	 * 
	 * @param key
	 * @param value
	 */
	public static void append(String key, String value) {
		try {
			Jedis jedis = openJedis();
			jedis.append(key, value);
			closeJedis(jedis);
		} catch (Exception e) {
		}

	}

	/**
	 * 根据字符串key获取值
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		try {
			Jedis jedis = openJedis();
			String value = jedis.get(key);
			return value;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 根据对象key查找
	 * 
	 * @param key
	 * @return
	 */
	public static Object getValue(byte[] key) {
		try {
			Jedis jedis = openJedis();
			byte[] b = jedis.get(key);
			Object o = SerializeUtil.unserialize(b);
			return o;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 删除
	 * 
	 * @param key
	 */
	public static void remove(String key) {
		try {
			Jedis jedis = openJedis();
			jedis.del(key);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 删除
	 * 
	 * @param key
	 */
	public static void remove(byte[] key) {
		try {
			Jedis jedis = openJedis();
			jedis.del(key);
		} catch (Exception e) {
		}
	}

	@Test
	public void test() {
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
