package com.physical.model;

import java.util.List;

import javax.persistence.Transient;

public class OwnerListInfo extends PageInfo{

	@Transient
	private List<String> ownerList;

	public List<String> getOwnerList() {
		return ownerList;
	}

	public void setOwnerList(List<String> ownerList) {
		this.ownerList = ownerList;
	}
	
}
