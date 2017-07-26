package com.shopin.oneposition.enums;

import com.shopin.oneposition.constants.InfoConstants;

/**
 * @author changePosition
 * @date 2017年7月10日 下午12:02:17
 * @DESC
 */
public enum EnumCodeInfo {
	用户注册失败(InfoConstants.INFO_CODE_FAIL,"用户注册失败"),
	用户登录失败(InfoConstants.INFO_CODE_FAIL,"账号或密码错误"),
	登录成功(InfoConstants.INFO_CODE_SUCCESS,"登录成功"),
	用户名已存在(InfoConstants.INFO_CODE_FAIL,"用户名已存在"),
	用户注册成功(InfoConstants.INFO_CODE_SUCCESS,"用户注册成功"),	
	验证码验证失败(InfoConstants.INFO_CODE_FAIL,"验证码验证失败"),	
	查询失败(InfoConstants.INFO_CODE_FAIL,"查询失败！"),
	查询结果为空(InfoConstants.INFO_CODE_EMPTY, "查询结果为空！"),
	操作成功(InfoConstants.INFO_CODE_SUCCESS, "操作成功！"),
	操作失败(InfoConstants.INFO_CODE_FAIL, "操作失败！");
	private String code;
	private String codeInfo;

	private EnumCodeInfo() {
		// TODO Auto-generated constructor stub
	}

	private EnumCodeInfo(String code, String codeInfo) {
		this.code = code;
		this.codeInfo = codeInfo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeInfo() {
		return codeInfo;
	}

	public void setCodeInfo(String codeInfo) {
		this.codeInfo = codeInfo;
	}

}
