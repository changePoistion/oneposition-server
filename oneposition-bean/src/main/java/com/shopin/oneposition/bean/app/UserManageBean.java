package com.shopin.oneposition.bean.app;

import java.util.Date;

public class UserManageBean extends BaseEntity {

	public UserManageBean() {
		super();
	}

	public UserManageBean(String userName, String userPasswd) {
		super();
		this.userName = userName;
		this.userPasswd = userPasswd;
	}

	private Integer sid;

	private String userName;

	private String userPasswd;

	private Date registerTime;

	private Boolean userStatus;
	
	private String mobileNo;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd == null ? null : userPasswd.trim();
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Boolean getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Boolean userStatus) {
		this.userStatus = userStatus;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
}