package com.shopin.oneposition.bean.app;

/**
 * @author changePosition
 * @date 2017年7月10日 下午5:05:59
 * @DESC 用户信息
 */
public class UserBean extends BaseEntity {
    private String userName;
    private String userPwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}