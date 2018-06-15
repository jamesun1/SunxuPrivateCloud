package com.physical.mapper;

import com.physical.model.Userinfo;
import com.physical.util.MyMapper;

public interface UserinfoMapper extends MyMapper<Userinfo>{

	Userinfo selectOneByPerson();
	
}