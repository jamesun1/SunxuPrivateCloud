package com.physical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.physical.model.Permission;
import com.physical.model.Treeinfo;
import com.physical.model.Useraccountinfo;
import com.physical.services.TreeService;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;
import com.physical.vo.PermissionVo;

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
	
	@RequestMapping(value = "selectInfoByParentid", method = { RequestMethod.POST })
	public ApiResult selectInfoByParentid(@RequestBody Treeinfo tree) {
		try {
			return treeService.selectInfoByParentid(tree);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
	
	@RequestMapping(value = "deleteTreeInfo", method = { RequestMethod.POST })
	public ApiResult deleteTreeInfo(@RequestBody Treeinfo tree) {
		try {
			return treeService.deleteTreeInfo(tree);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
	
	@RequestMapping(value = "selectUserByTreeid", method = { RequestMethod.POST })
	public ApiResult selectUserByTreeid(String treeid) {
		try {
			return treeService.selectUserByTreeid(treeid);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
	
	@RequestMapping(value = "insertUserByTreeid", method = { RequestMethod.POST })
	public ApiResult insertUserByTreeid(@RequestBody Useraccountinfo useraccountinfo) {
		try {
			return treeService.insertUserByTreeid(useraccountinfo);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
	
	@RequestMapping(value = "insertPermission", method = { RequestMethod.POST })
	public ApiResult insertPermission(@RequestBody PermissionVo permission) {
		try {
			return treeService.insertPermission(permission);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
	
}
