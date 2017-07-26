package com.shopin.oneposition.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopin.oneposition.bean.app.UserManageBean;
import com.shopin.oneposition.mapper.UserManageBeanMapper;

/**
 * @author changePosition
 * @date 2017年7月11日 下午1:10:24
 * @DESC 用户管理
 */
@Service
public class UserManageBeanService {
	@Autowired
	private UserManageBeanMapper userMapper;

	public List<UserManageBean> getUsers() {
		List<UserManageBean> list = new ArrayList<>();
		try {
			list.add(userMapper.selectByPrimaryKey(1));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public int registerUser(UserManageBean userBean) {
		// 判断用户名是否存在
		if (checkUserByName(userBean.getUserName())) {// 存在
			return -2;
		}
		int resultCode = userMapper.insert(userBean);
		return resultCode;
	}

	public UserManageBean userLogin(UserManageBean userInfo) {
		UserManageBean userBean = userMapper.userLogin(userInfo);
		return userBean;
	}

	public List<UserManageBean> queryByUserPasswd() {
		List<UserManageBean> list = new ArrayList<>();
		try {
			list.add(userMapper.queryByUserPasswd("22222"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("-----exception-----");
		}
		return list;
	}

	public boolean checkUserByName(String userName) {
		UserManageBean userManageBean = userMapper.queryByUserName(userName);
		if (userManageBean == null) {
			return false;
		} else {
			return true;
		}
	}
}
