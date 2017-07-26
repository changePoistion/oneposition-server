package com.shopin.oneposition.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopin.oneposition.bean.app.MvCollectionBean;
import com.shopin.oneposition.bean.app.MvCollectionList;
import com.shopin.oneposition.mapper.MvCollectionBeanMapper;

/**
 * @author changePosition
 * @date 2017年7月13日 下午5:13:59
 * @DESC
 */
@Service
public class MovieCollectService {
	@Autowired
	private MvCollectionBeanMapper collectMapper;

	public int saveToCollections(int userSid, MvCollectionBean record) {
		int responseCode;
		if (isCollect(userSid, record.getId())) {
			responseCode = -3;
		}
		responseCode = collectMapper.insert(record);
		return responseCode;
	}

	public boolean deleteFromCollections(int userSid, MvCollectionBean record) {
		int responseCode;
		if (!isCollect(userSid, record.getId())) {
			responseCode = -3;
		}
		responseCode = collectMapper.insert(record);
		if (responseCode == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isCollect(Integer userSid, Integer id) {
		MvCollectionBean collBean = collectMapper.selectByUserSidAndId(userSid, id);
		if (collBean != null) {
			return true;
		} else {
			return false;
		}
	}

	public MvCollectionList getAllCollectedList(Integer userSid) {
		List<MvCollectionBean> collections = collectMapper.selectAllCollected(userSid);
		if (collections == null) {
			collections = new ArrayList<>();
		}
		MvCollectionList collectionList = new MvCollectionList();
		collectionList.setCollections(collections);
		return collectionList;
	}

	public MvCollectionList getCollectedByIndex(Integer userSid, int index, int count) {
		Map<String, Object> map = new HashMap<>();
		map.put("userSid", userSid);
		map.put("index", index);
		map.put("count", count);
		List<MvCollectionBean> collections = collectMapper.selectCollectedByIndex(map);
		if (collections == null) {
			collections = new ArrayList<>();
		}
		MvCollectionList collectionList = new MvCollectionList();
		collectionList.setCollections(collections);
		return collectionList;
	}

}
