package com.shopin.oneposition.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.shopin.oneposition.bean.app.MvCollectionBean;

public interface MvCollectionBeanMapper {
	
	int deleteByPrimaryKey(Integer sid);

	int insert(MvCollectionBean record);

	int insertSelective(MvCollectionBean record);

	MvCollectionBean selectByPrimaryKey(Integer sid);

	MvCollectionBean selectByMovieId(Integer id);

	@Select("select * from mv_collection where user_sid = #{0} and id = #{1}")
	MvCollectionBean selectByUserSidAndId(Integer user_sid, Integer id);

	@Select("select count(0) from mv_collection where user_sid = #{0}")
	int selectCollectCount(Integer user_sid);

	// 分页查询
	// @Select("select * from mv_collection where user_sid = #{0} limit ")
	List<MvCollectionBean> selectCollectedByIndex(Integer user_sid, int index, int count);

	List<MvCollectionBean> selectCollectedByIndex(Map<String, Object> map);

	List<MvCollectionBean> selectAllCollected(Integer user_sid);

	int updateByPrimaryKeySelective(MvCollectionBean record);

	int updateByPrimaryKey(MvCollectionBean record);
}