package com.physical.util;

import javax.servlet.http.HttpServletRequest;

public interface RedisTokenService {

	String getUserIdByToken(HttpServletRequest request);

	String getToken(HttpServletRequest request);

}
