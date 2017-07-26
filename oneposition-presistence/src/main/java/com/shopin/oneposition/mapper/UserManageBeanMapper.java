package com.shopin.oneposition.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.shopin.oneposition.bean.app.UserManageBean;

public interface UserManageBeanMapper {
	int deleteByPrimaryKey(Integer sid);

	int insert(UserManageBean record);

	int insertSelective(UserManageBean record);

	UserManageBean selectByPrimaryKey(Integer sid);

	@Select("select * from user_manage u where u.user_name = #{userName} and u.user_passwd = #{userPasswd}")
	@Results({ @Result(column = "user_name", property = "userName"),
			@Result(column = "user_passwd", property = "userPasswd"),
			@Result(column = "register_time", property = "registerTime", javaType = Date.class),
			@Result(column = "user_status", property = "userStatus"),
			@Result(column = "mobile_no", property = "mobileNo")})
	UserManageBean userLogin(UserManageBean userBean);

	UserManageBean queryByUserPasswd(String user_passwd);

	UserManageBean queryByUserName(String user_name);

	int updateByPrimaryKeySelective(UserManageBean record);

	int updateByPrimaryKey(UserManageBean record);
}