package com.shopin.oneposition.enums;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

import com.shopin.oneposition.constants.Constants;

/**
 * @author changePosition
 * @version 2017年7月9日 下午2:29:01
 * @DESC 地址映射
 */
public enum EnumServerMap {
	movie(Constants.TAG_MOVIE, "http://moviewapp.dazui.com"),
	heart(Constants.TAG_HEART, "http://api.xinliji.me"), 
	live(Constants.TAG_LIVE,""), 
	ocean(Constants.TAG_OCEAN, "http://mrobot.pconline.com.cn"), 
	balloon(Constants.TAG_BALLOON, "");
	private int tag;
	private String baseUrl;

	
	private EnumServerMap(int tag, String baseUrl) {
		// TODO Auto-generated constructor stub
		this.tag = tag;
		this.baseUrl = baseUrl;
	}
    private static EnumServerMap getEnumByTag(int tag) {
        for (EnumServerMap enumServerMap : EnumServerMap.values()) {
            if (enumServerMap.getTag() == tag) {
                return enumServerMap;
            }
        }
        return null;
    }
    public static String getUrlByTag(int tag) {
    	EnumServerMap serverMap = getEnumByTag(tag);
        if (serverMap != null) {
            return serverMap.getBaseUrl();
        }
        return "";
    }

	public int getTag() {
		return tag;
	}

	public String getBaseUrl() {
		return baseUrl;
	}
	
}
