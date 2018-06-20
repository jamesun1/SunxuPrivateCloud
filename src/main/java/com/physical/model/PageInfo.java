package com.physical.model;

import javax.persistence.Transient;

public class PageInfo {
	@Transient
	private int startNums;//开始条数
	@Transient
	private int endNums;//结束条数
	@Transient
	private int currentPage;//当前页数
	@Transient
	private int pageSize; //当前页数的显示的条数
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartNums() {
		return startNums;
	}

	public void setStartNums(int startNums) {
		this.startNums = startNums;
	}

	public int getEndNums() {
		return endNums;
	}

	public void setEndNums(int endNums) {
		this.endNums = endNums;
	}

}
