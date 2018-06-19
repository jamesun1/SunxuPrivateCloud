package com.physical.mapper;

import java.util.List;

import com.physical.model.Userinfo;
import com.physical.util.MyMapper;

public interface UserinfoMapper extends MyMapper<Userinfo>{

	Userinfo selectOneByPerson();

	List<String> selectAllUser();
	
}