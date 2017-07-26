package com.shopin.oneposition.bean.app;

import java.util.List;

/**
 * @author changePosition
 * @date 2017年7月14日 下午3:21:25
 * @DESC
 */
public class MvCollectionList extends BaseEntity {
	private List<MvCollectionBean> collections;

	public List<MvCollectionBean> getCollections() {
		return collections;
	}

	public void setCollections(List<MvCollectionBean> collections) {
		this.collections = collections;
	}
}
