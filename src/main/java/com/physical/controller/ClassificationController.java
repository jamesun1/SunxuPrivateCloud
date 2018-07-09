package com.physical.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.physical.model.Classification;
import com.physical.model.PageInfo;
import com.physical.model.Tableinfo;
import com.physical.services.ClassificationService;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;
import com.physical.util.PageInfoHelper;

@RestController
@RequestMapping("classification")
public class ClassificationController {

	@Autowired
	private ClassificationService classificationService;
	
	@RequestMapping("selectAll")
	public ApiResult selectAll(HttpServletRequest request) {
		try {
			return classificationService.selectAll();
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
}
