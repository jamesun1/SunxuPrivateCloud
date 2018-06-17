package com.physical.services.imp;

import java.util.List;
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
public class UserServiceImp implements UserService {

	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private RedisService redisService;

	@Override
	public ApiResult login(Userinfo user) throws LogicalException {
		try {
			Userinfo userinfo = userinfoMapper.selectOne(user);
			if (userinfo != null) {
				String token = UUID.randomUUID().toString();
				redisService.set(token, userinfo.getUserid(), (long) (30 * 60));
				return ApiResult.success(token);
			} else {
				return ApiResult.fail("登录失败");
			}
		} catch (Exception e) {
			throw new LogicalException("创建操作异常！");
		}

	}

	@Override
	public ApiResult userinfo(String id) throws LogicalException {
		try {
			Userinfo user = userinfoMapper.selectByPrimaryKey(id);
			return ApiResult.success(user);
		} catch (Exception e) {
			throw new LogicalException("创建操作异常！");
		}
	}

	@Override
	public ApiResult logout(String token) throws LogicalException {
		try {
			if (redisService.exists(token)) {
				redisService.remove(token);
			}
			return ApiResult.success();
		} catch (Exception e) {
			throw new LogicalException("创建操作异常！");
		}
	}

	@Override
	public ApiResult insgister(Userinfo userinfo) throws LogicalException {
		Userinfo user = new Userinfo();
		user.setUser(userinfo.getUser());
		List<Userinfo> userlist = userinfoMapper.select(user);
		if(userlist.size() == 0){
			userinfo.setUserid(UUID.randomUUID().toString());
			userinfo.setRole("1");
			userinfoMapper.insert(userinfo);
			return ApiResult.success();
		}else{
			return ApiResult.fail("此账号已经被人抢先注册");
		}
		
	}

}
