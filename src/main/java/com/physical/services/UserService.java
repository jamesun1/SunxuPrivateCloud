package com.physical.services;

import com.physical.model.Userinfo;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;

public interface UserService {

	ApiResult login(Userinfo user) throws LogicalException;

	ApiResult userinfo(String token)throws LogicalException;

}
