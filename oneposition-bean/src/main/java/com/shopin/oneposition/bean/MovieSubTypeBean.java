package com.shopin.oneposition.bean;

import com.shopin.oneposition.bean.app.BaseEntity;

/** 
* @author changePosition 
* @version 2017年7月9日 下午4:21:05 
* @DESC 
*/
public class MovieSubTypeBean extends BaseEntity {
    private int id;
    private String name;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
