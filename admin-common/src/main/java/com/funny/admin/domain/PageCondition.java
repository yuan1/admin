package com.funny.admin.domain;

import java.io.Serializable;

/**
 * 分页封装类
 * @author Administrator
 *
 */
public class PageCondition implements Serializable{
	protected int pageNo = 1;
	protected int pageSize = 20;

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
