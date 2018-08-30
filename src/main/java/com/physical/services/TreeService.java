package com.physical.services;

import com.physical.model.Permission;
import com.physical.model.Treeinfo;
import com.physical.model.Useraccountinfo;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;
import com.physical.vo.PermissionVo;

public interface TreeService {

	ApiResult selectTreeInfo()throws LogicalException;

	ApiResult insertTreeInfo(Treeinfo tree)throws LogicalException;

	ApiResult selectInfoByParentid(Treeinfo tree)throws LogicalException;

	ApiResult deleteTreeInfo(Treeinfo tree)throws LogicalException;

	ApiResult selectUserByTreeid(String treeid)throws LogicalException;

	ApiResult insertUserByTreeid(Useraccountinfo useraccountinfo)throws LogicalException;

	ApiResult insertPermission(PermissionVo permission)throws LogicalException;


}
