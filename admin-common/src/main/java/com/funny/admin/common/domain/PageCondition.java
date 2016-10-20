package com.funny.admin.common.domain;

import java.io.Serializable;

/**
 * 分页封装类
 * Created by fangli@autohome.com.cn on 2016/8/6.
 */
public class PageCondition implements Serializable{
	protected int pageNo = 1;
	protected int pageSize = 10;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
