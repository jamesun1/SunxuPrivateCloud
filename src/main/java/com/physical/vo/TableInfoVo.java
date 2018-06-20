package com.physical.vo;

import java.util.List;

import com.physical.model.Tableinfo;

public class TableInfoVo{
	
	private List<Tableinfo> tableinfoList;

	public List<Tableinfo> getTableinfoList() {
		return tableinfoList;
	}

	public void setTableinfoList(List<Tableinfo> tableinfoList) {
		this.tableinfoList = tableinfoList;
	}
	
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
