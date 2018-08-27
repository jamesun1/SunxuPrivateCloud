package com.physical.util;

import org.springframework.beans.BeanUtils;

import com.physical.model.PageInfo;

public class PageInfoHelper {

	public static PageInfo pageInit(Object o) {
		PageInfo pageInfo = new PageInfo();
		BeanUtils.copyProperties(o, pageInfo);

		pageInfo.setStartNums(pageInfo.getPageSize() * (pageInfo.getCurrentPage() - 1));
		return pageInfo;
	}
}
