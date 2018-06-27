package com.physical.mapper;

import java.util.List;

import com.physical.model.Treeinfo;
import com.physical.util.MyMapper;

public interface TreeinfoMapper extends MyMapper<Treeinfo>{

	List<Treeinfo> selectTreeInfo();

	List<Treeinfo> selectInfoByParentid(Treeinfo tree);
	
}