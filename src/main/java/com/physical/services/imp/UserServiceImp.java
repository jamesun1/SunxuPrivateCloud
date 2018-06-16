package com.physical.services.imp;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.physical.RedisService;
import com.physical.mapper.UserinfoMapper;
import com.physical.model.Userinfo;
import com.physical.services.UserService;
import com.physical.util.ApiResult;
import com.physical.util.JedisUtils;
import com.physical.util.LogicalException;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private RedisService redisService;

	@Override
	public ApiResult login(Userinfo user) throws LogicalException {
		try {
			Userinfo userinfo = userinfoMapper.selectOne(user);
			if(userinfo != null) {
				String token = UUID.randomUUID().toString();
				redisService.set(token, userinfo.getUserid(),(long) (30*60));
				return ApiResult.success(token);
			}else {
				return ApiResult.fail("登录失败");
			}
		}catch (Exception e) {
			throw new LogicalException("创建操作异常！");
		}
		
	}

	@Override
	public ApiResult userinfo(String id) throws LogicalException {
		try{
			Userinfo user = userinfoMapper.selectByPrimaryKey(id);
			return ApiResult.success(user);
		}catch (Exception e) {
			throw new LogicalException("创建操作异常！");
		}
	}

}
