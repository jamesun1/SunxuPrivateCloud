package com.physical.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.physical.model.Tableinfo;
import com.physical.services.TableService;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;
import com.physical.util.RedisTokenService;

@RestController
@RequestMapping("table")
public class TableController {

	@Autowired
	private TableService tableService;
	@Autowired
	private RedisTokenService redisTokenService;
	
	@RequestMapping("selectAll")
	public ApiResult selectAll(HttpServletRequest request) {
		try {
			Tableinfo table = new Tableinfo();
			table.setOwnerList(redisTokenService.getOwnerList(request));
			
			return tableService.selectAll(table);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
	
	@RequestMapping("insert")
	public ApiResult insert(@RequestBody Tableinfo table,HttpServletRequest request) {
		try {
			table.setStatus("0");
			table.setOwner(redisTokenService.getUserIdByToken(request));
			return tableService.insert(table);
		}catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
	
}
