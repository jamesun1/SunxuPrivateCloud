package com.physical.services.imp;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.physical.mapper.PermissionMapper;
import com.physical.mapper.TreeinfoMapper;
import com.physical.mapper.UseraccountinfoMapper;
import com.physical.model.Permission;
import com.physical.model.Treeinfo;
import com.physical.model.Useraccountinfo;
import com.physical.services.TreeService;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;
import com.physical.vo.PermissionVo;

import tk.mybatis.mapper.util.StringUtil;

@Service
public class TreeServiceImp implements TreeService{
	private static Logger log = LoggerFactory.getLogger(TreeServiceImp.class);

	@Autowired
	private TreeinfoMapper treeinfoMapper;
	@Autowired
	private UseraccountinfoMapper useraccountinfoMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	
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

	@Override
	public ApiResult insertPermission(PermissionVo permission) throws LogicalException {
		try {
			permissionMapper.deleteAll();
			for(Treeinfo item : permission.getTreeList()) {
				String treeid = item.getTreeid();
				Treeinfo tree = new Treeinfo();
				tree = treeinfoMapper.selectByPrimaryKey(treeid);
				if(!StringUtils.isNullOrEmpty(tree.getParentid())) {
					Permission per = new Permission();
					per.setTreeid(tree.getParentid());
					int count = permissionMapper.selectCount(per);
					if(count==0) {
						per.setRoleid("角色1");
						permissionMapper.insert(per);
					}
					per.setRoleid("角色1");
					per.setTreeid(treeid);
					permissionMapper.insert(per);
				}else {
					Permission per = new Permission();
					per.setTreeid(treeid);
					int count = permissionMapper.selectCount(per);
					if(count==0) {
						per.setRoleid("角色1");
						permissionMapper.insert(per);
					}
				}
			}
			return ApiResult.success();
		}catch (Exception e) {
			throw new LogicalException("操作失败");
		}
	}
	
}
