package com.physical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.StringUtils;
import com.physical.model.Userinfo;
import com.physical.services.UserService;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired 
	private UserService userService;
	
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
	public ApiResult userinfo(String token) {
		try {
			if(StringUtils.isNullOrEmpty(token)){
				ApiResult.fail("请重新登陆");
			}
			return userService.userinfo(token);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
}
