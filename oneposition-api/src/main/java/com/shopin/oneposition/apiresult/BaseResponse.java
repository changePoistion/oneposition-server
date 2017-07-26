package com.shopin.oneposition.apiresult;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.shopin.oneposition.enums.EnumCodeInfo;

/**
 * @author changePosition
 * @version 2017年7月9日 下午3:05:19
 * @DESC 返回给app端的基类
 */
public class BaseResponse {
	private String code;
	private String codeInfo;
	private Object data;

	public BaseResponse() {
		super();
	}

	public BaseResponse(EnumCodeInfo codeInfo) {
		this(codeInfo, "");
	}

	public BaseResponse(EnumCodeInfo codeInfo, String info) {
		super();
		this.code = codeInfo.getCode();
		this.codeInfo = codeInfo.getCodeInfo() + info;
	}

	public BaseResponse(Object baseEntity, EnumCodeInfo codeInfo) {
		super();
		this.code = codeInfo.getCode();
		this.codeInfo = codeInfo.getCodeInfo();
		this.data = baseEntity;
	}

	public BaseResponse(Object baseEntity, EnumCodeInfo codeInfo, String info) {
		super();
		this.code = codeInfo.getCode();
		this.codeInfo = codeInfo.getCodeInfo() + info;
		this.data = baseEntity;
	}

	public static BaseResponse Y(EnumCodeInfo codeInfo) {
		return new BaseResponse(null, codeInfo, "");
	}

	public static BaseResponse Y(Object baseEntity, EnumCodeInfo codeInfo) {
		return new BaseResponse(baseEntity, codeInfo, "");
	}

	public static BaseResponse N(EnumCodeInfo codeInfo) {
		return new BaseResponse(null, codeInfo, "");
	}

	public static BaseResponse N(EnumCodeInfo codeInfo, String info) {
		return new BaseResponse(null, codeInfo, info);
	}

	public static BaseResponse N(Object baseEntity, EnumCodeInfo codeInfo) {
		return new BaseResponse(baseEntity, codeInfo, "");
	}

	public static BaseResponse N(Object baseEntity, EnumCodeInfo codeInfo, String info) {
		return new BaseResponse(baseEntity, codeInfo, info);
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
