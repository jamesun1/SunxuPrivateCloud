package com.physical.services.imp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.physical.mapper.ClassificationMapper;
import com.physical.mapper.DictionaryMapper;
import com.physical.model.Classification;
import com.physical.model.Dictionary;
import com.physical.services.ClassificationService;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;

@Service
public class ClassificationServiceImp implements ClassificationService{

	@Autowired
	private ClassificationMapper classificationMapper;
	
	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	@Override
	public ApiResult selectAll() throws LogicalException {
		try {
			Classification ification = new Classification();
			ification.setStatus("0");
			return ApiResult.success(classificationMapper.select(ification));
		}catch (Exception e) {
			throw new LogicalException("这个人没有权限");
		}
	}

	@Override
	public ApiResult deleteInfo(Classification classification) throws LogicalException {
		try {
			Classification code = new Classification();
			code.setCode(classification.getCode());
			List<Classification> classificationList = classificationMapper.select(code);
			for(Classification item : classificationList) {
				Dictionary dictory = new Dictionary();
				dictory.setClassificationid(item.getClassificationid());
				dictionaryMapper.delete(dictory);
			}
			classificationMapper.deleteByPrimaryKey(classification);
			return ApiResult.success();
		}catch (Exception e) {
			throw new LogicalException("这个人没有权限");
		}
	}

	@Override
	public ApiResult insert(Classification classification) throws LogicalException {
		try {
			Classification ification = new Classification();
			ification.setCode(classification.getCode());
			List<Classification> ificationList = classificationMapper.select(ification);
			if(ificationList.size() == 0) {
				classification.setClassificationid(UUID.randomUUID().toString());
				classification.setStatus("0");
				classificationMapper.insert(classification);
			}else {
				throw new LogicalException("此code编码已被使用，请更换code");
			}
			return ApiResult.success();
		}catch (Exception e) {
			throw new LogicalException(e.getMessage());
		}
	}
}
