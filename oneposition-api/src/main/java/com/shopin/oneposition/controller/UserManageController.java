package com.shopin.oneposition.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.shopin.oneposition.apiresult.BaseResponse;
import com.shopin.oneposition.bean.IdentifyCodeResult;
import com.shopin.oneposition.bean.app.UserManageBean;
import com.shopin.oneposition.enums.EnumCodeInfo;

/**
 * @author changePosition
 * @date 2017年7月12日 下午2:30:27
 * @DESC 用户管理
 */
@RestController
@RequestMapping("/user")
public class UserManageController extends BaseController {

	@RequestMapping(value = "/register", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public BaseResponse userUegister(@RequestParam Map<String, Object> map) {
		BaseResponse response = null;
		if (map == null) {
			response = BaseResponse.N(false, EnumCodeInfo.用户注册失败);
		} else {
			String userName = (String) map.get("userName");
			String userPwd = (String) map.get("userPwd");
			String mobile = (String) map.get("mobile");
			if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(userPwd)) {
				response = BaseResponse.N(false, EnumCodeInfo.用户注册失败);
			} else {
				// 验证 identifyCode
				String identifyCode = (String) map.get("identifyCode");
				String params = "appkey=1f622c8ab7860&phone=" + mobile + "&zone=86&code=" + identifyCode;
				if (!checkoutCode(params)) {//校验失败
					response = BaseResponse.Y(false, EnumCodeInfo.验证码验证失败);
					return response;
				}
				UserManageBean userBean = new UserManageBean();
				userBean.setUserName(userName);
				userBean.setUserPasswd(userPwd);
				userBean.setRegisterTime(new Date());
				userBean.setUserStatus(false);
				int resultCode = userService.registerUser(userBean);
				if (resultCode == 1) {
					response = BaseResponse.Y(true, EnumCodeInfo.用户注册成功);
				} else if (resultCode == -2) {
					response = BaseResponse.N(false, EnumCodeInfo.用户名已存在);
				} else {
					response = BaseResponse.N(false, EnumCodeInfo.用户注册失败);
				}
			}
		}
		return response;
	}

	public BaseResponse getIdentifyCode() {
		BaseResponse response = null;
		return response;
	}

	@RequestMapping(value = "/login/{userName}/{userPwd}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	public BaseResponse login(@PathVariable("userName") String userName, @PathVariable("userPwd") String userPwd) {
		BaseResponse response = null;
		UserManageBean userBean = userService.userLogin(new UserManageBean(userName, userPwd));
		if (userBean == null) {
			response = BaseResponse.N(EnumCodeInfo.用户登录失败);
		} else {
			response = BaseResponse.Y(userBean, EnumCodeInfo.登录成功);
		}
		return response;
	}

	/**
	 * 校验验证码
	 * 
	 * @param map
	 * @return
	 */
	private boolean checkoutCode(String params) {
		HttpEntity<String> entity = new HttpEntity<>(params);
		String resultStr = restTemplate.postForObject("https://webapi.sms.mob.com/sms/verify", entity, String.class);
		logger.info(resultStr);
		IdentifyCodeResult result = null;
		try {
			result = JSON.parseObject(resultStr, IdentifyCodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result != null &&  result.getStatus() == 200) {
			return true;
		} else {
			return false;
		}
	}

}
