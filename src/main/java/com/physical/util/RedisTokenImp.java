package com.physical.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.physical.RedisService;

@Service
public class RedisTokenImp implements RedisTokenService{

	@Autowired
	private RedisService redisService;
	private final static String X_TOKEN = "X-Token";

	@Override
	public String getUserIdByToken(HttpServletRequest request) {
		String token = request.getHeader(X_TOKEN);
		if(!StringUtils.isNullOrEmpty(token)){
			String userid = redisService.get(token).toString();
			return userid;
		}else{
			return null;
		}
	}
	
	
}
