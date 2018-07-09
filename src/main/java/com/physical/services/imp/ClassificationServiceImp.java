package com.physical.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.physical.mapper.ClassificationMapper;
import com.physical.model.Classification;
import com.physical.services.ClassificationService;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;

@Service
public class ClassificationServiceImp implements ClassificationService{

	@Autowired
	private ClassificationMapper classificationMapper;
	
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

}
