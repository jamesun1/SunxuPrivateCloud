package com.physical.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.physical.mapper.TreeinfoMapper;
import com.physical.model.Treeinfo;
import com.physical.services.TreeService;
import com.physical.util.ApiResult;

@Service
public class TreeServiceImp implements TreeService{

	@Autowired
	private TreeinfoMapper treeinfoMapper;
	
	@Override
	public ApiResult selectTreeInfo() {
		Treeinfo tree = new Treeinfo();
		tree.setParentid(null);
		tree.setStatus("0");
		List<Treeinfo> treeInfo = treeinfoMapper.select(tree);
		return ApiResult.success(treeInfo);
	}
	
}
