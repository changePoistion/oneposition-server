package com.shopin.oneposition.condition;

/**
 * @author changePosition
 * @version 2017年7月9日 下午2:52:09
 * @DESC
 */
public class MovieCondition extends BaseCondition {
	private String fromTime;//时间戳
	private int count;//每次请求的条数
	private int category;
	private int type;
	private int subtype;
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getSubtype() {
		return subtype;
	}
	public void setSubtype(int subtype) {
		this.subtype = subtype;
	}
	
}
