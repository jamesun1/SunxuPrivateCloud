package com.physical.services;

import com.physical.model.Treeinfo;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;

public interface TreeService {

	ApiResult selectTreeInfo()throws LogicalException;

	ApiResult insertTreeInfo(Treeinfo tree)throws LogicalException;

}
