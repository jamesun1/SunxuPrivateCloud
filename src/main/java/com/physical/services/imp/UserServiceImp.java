package com.physical.services.imp;

import java.util.ArrayList;
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
				//token >>>> userid
				redisService.set(token, userinfo.getUserid());
				
				List<String> list = new ArrayList<String>();
				if(userinfo.getRole().equals("0")) {
					list = userinfoMapper.selectAllUser();
				}else {
					list.add(userinfo.getUserid());
				}
				
				//userid >>>> role
				redisService.add(userinfo.getUserid(), list);
				
				return ApiResult.success(token);
			} else {
				return ApiResult.fail("登录失败,请检查用户名密码");
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
				String id = (String) redisService.get(token);
				redisService.remove(token);
				if(redisService.exists(id)) {
					redisService.remove(id);
				}
			}
			return ApiResult.success();
		} catch (Exception e) {
			throw new LogicalException("退出清除redis异常！");
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
