package com.physical.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface RedisTokenService {

	String getUserIdByToken(HttpServletRequest request);

	String getToken(HttpServletRequest request);

	List<String> getOwnerList(HttpServletRequest request);
}
