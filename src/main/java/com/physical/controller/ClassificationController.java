package com.physical.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.physical.model.Classification;
import com.physical.model.Dictionary;
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
	
	@RequestMapping("deleteInfo")
	public ApiResult deleteInfo(HttpServletRequest request,@RequestBody Classification classification) {
		try {
			return classificationService.deleteInfo(classification);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
	
	@RequestMapping("insert")
	public ApiResult insert(HttpServletRequest request,@RequestBody Classification classification) {
		try {
			return classificationService.insert(classification);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
	
	@RequestMapping("selectById")
	public ApiResult selectById(HttpServletRequest request,@RequestBody Classification classification) {
		try {
			return classificationService.selectById(classification);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
	
	@RequestMapping("insertDictionary")
	public ApiResult insertDictionary(HttpServletRequest request,@RequestBody Dictionary dictionary) {
		try {
			return classificationService.insertDictionary(dictionary);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
}
