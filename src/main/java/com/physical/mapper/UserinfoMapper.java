package com.physical.mapper;

import com.physical.model.Userinfo;
import com.physical.util.MyMapper;

public interface UserinfoMapper extends MyMapper<UserinfoMapper>{
    int deleteByPrimaryKey(String userid);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}