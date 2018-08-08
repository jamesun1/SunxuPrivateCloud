package com.physical.services.imp;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.physical.mapper.TreeinfoMapper;
import com.physical.mapper.UseraccountinfoMapper;
import com.physical.model.Treeinfo;
import com.physical.model.Useraccountinfo;
import com.physical.services.TreeService;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;

@Service
public class TreeServiceImp implements TreeService{
	private static Logger log = LoggerFactory.getLogger(TreeServiceImp.class);

	@Autowired
	private TreeinfoMapper treeinfoMapper;
	@Autowired
	private UseraccountinfoMapper useraccountinfoMapper;
	
	@Override
	public ApiResult selectTreeInfo() throws LogicalException {
		try {
			List<Treeinfo> treeInfo = treeinfoMapper.selectTreeInfo();
			return ApiResult.success(treeInfo);
		}catch (Exception e) {
			throw new LogicalException("操作失败");
		}
	}

	@Override
	public ApiResult insertTreeInfo(Treeinfo tree) throws LogicalException {
		try {
			tree.setTreeid(UUID.randomUUID().toString());
			tree.setStatus("0");
			treeinfoMapper.insert(tree);
			return ApiResult.success();	
		}catch (Exception e) {
			throw new LogicalException("操作失败");
		}
	}

	@Override
	public ApiResult selectInfoByParentid(Treeinfo tree) throws LogicalException {
		try {
			tree.setStatus("0");
			List<Treeinfo> treeinfoList = treeinfoMapper.selectInfoByParentid(tree);
			return ApiResult.success(treeinfoList);	
		}catch (Exception e) {
			log.warn(e.toString());
			throw new LogicalException("操作失败");
		}
	}

	@Override
	public ApiResult deleteTreeInfo(Treeinfo tree) throws LogicalException {
		try {
			tree.setStatus("1");
			treeinfoMapper.updateByPrimaryKeySelective(tree);
			return ApiResult.success();	
		}catch (Exception e) {
			throw new LogicalException("操作失败");
		}
	}

	@Override
	public ApiResult selectUserByTreeid(String treeid) throws LogicalException {
		try {
			Useraccountinfo useraccountinfo = new Useraccountinfo();
			useraccountinfo.setTreeid(treeid);
			List<Useraccountinfo> userList = useraccountinfoMapper.select(useraccountinfo);
			return ApiResult.success(userList);
		}catch (Exception e) {
			throw new LogicalException("操作失败");
		}
	}

	@Override
	public ApiResult insertUserByTreeid(Useraccountinfo useraccountinfo) throws LogicalException {
		try {
			useraccountinfo.setUseraccountinfoid(UUID.randomUUID().toString());
			useraccountinfoMapper.insert(useraccountinfo);
			return ApiResult.success();
		}catch (Exception e) {
			throw new LogicalException("操作失败");
		}
	}
	
}
