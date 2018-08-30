package com.physical.vo;

import java.util.List;

import com.physical.model.Permission;
import com.physical.model.Treeinfo;

public class PermissionVo {
	private List<Permission> perlist;

	public List<Permission> getPerlist() {
		return perlist;
	}

	public void setPerlist(List<Permission> perlist) {
		this.perlist = perlist;
	}
	
	private List<Treeinfo> treeList;

	public List<Treeinfo> getTreeList() {
		return treeList;
	}

	public void setTreeList(List<Treeinfo> treeList) {
		this.treeList = treeList;
	}
	
	
}
