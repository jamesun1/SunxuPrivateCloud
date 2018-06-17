package com.physical.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.StringUtils;
import com.physical.model.Userinfo;
import com.physical.services.UserService;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;
import com.physical.util.RedisTokenService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired 
	private UserService userService;
	@Autowired
	private RedisTokenService redisTokenService;
	
	@RequestMapping("login")
	public ApiResult login(@RequestBody Userinfo user) {
		try {
			return userService.login(user);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
	
	@RequestMapping("userinfo")
	public ApiResult userinfo(HttpServletRequest request) {
		try {
			String id = redisTokenService.getUserIdByToken(request);
			if(StringUtils.isNullOrEmpty(id)){
				ApiResult.fail("请重新登陆");
			}
			return userService.userinfo(id);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
	
	@RequestMapping("logout")
	public ApiResult logout(HttpServletRequest request) {
		try {
			String token = redisTokenService.getToken(request);
			return userService.logout(token);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
	
	@RequestMapping("insgister")
	public ApiResult insgister(@RequestBody Userinfo userinfo,HttpServletRequest request) {
		try {
			if(userinfo == null){
				throw new LogicalException("请输入账号密码");
			}
			return userService.insgister(userinfo);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
}
