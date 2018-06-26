package com.physical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.physical.services.TreeService;
import com.physical.util.ApiResult;

@RestController
@RequestMapping("tree")
public class TreeController {

	@Autowired
	private TreeService treeService;
	
	@RequestMapping(value = "selectTreeInfo", method = { RequestMethod.GET })
	public ApiResult selectTreeInfo() {
		return treeService.selectTreeInfo();
	}
}
