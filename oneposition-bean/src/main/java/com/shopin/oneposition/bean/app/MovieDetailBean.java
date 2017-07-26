package com.shopin.oneposition.bean.app;

/**
 * @author changePosition
 * @date 2017年7月10日 下午3:04:23
 * @DESC
 */
public class MovieDetailBean extends BaseEntity {
	private String webInfo;
	private boolean isCollected;

	public String getWebInfo() {
		return webInfo;
	}

	public void setWebInfo(String webInfo) {
		this.webInfo = webInfo;
	}

	public boolean isCollected() {
		return isCollected;
	}

	public void setCollected(boolean isCollected) {
		this.isCollected = isCollected;
	}
}
