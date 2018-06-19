package com.physical.services;

import com.physical.model.Tableinfo;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;

public interface TableService {

	ApiResult selectAll(Tableinfo table)throws LogicalException;

	ApiResult insert(Tableinfo table)throws LogicalException;

}
