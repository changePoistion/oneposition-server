package com.shopin.oneposition.bean.app;
/** 
* @author changePosition 
* @date 2017年7月25日 上午9:44:06 
* @DESC 简单的分页实体类
*/
public class PageEntity extends BaseEntity {
	//mySql index begins with 0,Oracle with 1.
	private int index;
	private int pageSize;
	private int totalPage;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
