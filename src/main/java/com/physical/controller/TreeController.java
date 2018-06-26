package com.physical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.physical.model.Treeinfo;
import com.physical.services.TreeService;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;

@RestController
@RequestMapping("tree")
public class TreeController {

	@Autowired
	private TreeService treeService;

	@RequestMapping(value = "selectTreeInfo", method = { RequestMethod.GET })
	public ApiResult selectTreeInfo() {
		try {
			return treeService.selectTreeInfo();
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}

	@RequestMapping(value = "insertTreeInfo", method = { RequestMethod.POST })
	public ApiResult insertTreeInfo(@RequestBody Treeinfo tree) {
		try {
			return treeService.insertTreeInfo(tree);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
}
