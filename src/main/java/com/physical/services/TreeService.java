package com.physical.services;

import com.physical.model.Treeinfo;
import com.physical.model.Useraccountinfo;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;

public interface TreeService {

	ApiResult selectTreeInfo()throws LogicalException;

	ApiResult insertTreeInfo(Treeinfo tree)throws LogicalException;

	ApiResult selectInfoByParentid(Treeinfo tree)throws LogicalException;

	ApiResult deleteTreeInfo(Treeinfo tree)throws LogicalException;

	ApiResult selectUserByTreeid(String treeid)throws LogicalException;

	ApiResult insertUserByTreeid(Useraccountinfo useraccountinfo)throws LogicalException;


}
