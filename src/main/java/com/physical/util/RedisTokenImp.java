package com.physical.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

	@Override
	public String getToken(HttpServletRequest request) {
		String token = request.getHeader(X_TOKEN);
		return token;
	}

	@Override
	public List<String> getOwnerList(HttpServletRequest request) {
		String token = request.getHeader(X_TOKEN);
		if(!StringUtils.isNullOrEmpty(token)){
			String userid = redisService.get(token).toString();
			Set<Object> set = redisService.setMembers(userid);
			
			List<String> strList = new ArrayList<String>();
			
			List<Object> setList =(List<Object>) set.iterator().next();  
			for(Object object : setList) {
				strList.add((String)object);
			}
			
			return strList;
		}else{
			return null;
		}
	}
	
	
}
