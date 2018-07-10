package com.physical.services;

import com.physical.model.Classification;
import com.physical.model.Dictionary;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;

public interface ClassificationService {

	ApiResult selectAll()throws LogicalException;

	ApiResult deleteInfo(Classification classification)throws LogicalException;

	ApiResult insert(Classification classification)throws LogicalException;

	ApiResult selectById(Classification classification)throws LogicalException;

	ApiResult insertDictionary(Dictionary dictionary)throws LogicalException;

	ApiResult deleteDictionary(Dictionary dictionary)throws LogicalException;

	ApiResult selectByCode(Classification classification)throws LogicalException;

}
