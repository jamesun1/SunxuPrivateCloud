package com.physical.services;

import com.physical.util.ApiResult;
import com.physical.util.LogicalException;

public interface ClassificationService {

	ApiResult selectAll()throws LogicalException;

}
