package com.shopin.oneposition.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.shopin.oneposition.apiresult.BaseResponse;
import com.shopin.oneposition.bean.MovieListBean;
import com.shopin.oneposition.bean.app.MovieDetailBean;
import com.shopin.oneposition.bean.app.MovieNostalgiaBean;
import com.shopin.oneposition.bean.app.MvCollectionBean;
import com.shopin.oneposition.bean.app.MvCollectionList;
import com.shopin.oneposition.bean.app.MvPieceBean;
import com.shopin.oneposition.bean.app.MvPiecesBean;
import com.shopin.oneposition.condition.MovieCondition;
import com.shopin.oneposition.constants.Constants;
import com.shopin.oneposition.enums.EnumCodeInfo;
import com.shopin.oneposition.enums.EnumServerMap;

/**
 * @author changePosition
 * @version 2017年7月9日 上午11:27:17
 * @DESC 电影接口
 */
@RestController
@RequestMapping("/movie")
public class MovieController extends BaseController {

	/**
	 * 获取电影列表
	 * 
	 * @param movieCondition
	 * @return
	 */
	@RequestMapping(value = "/getMovieList", produces = "application/json;charset=UTF-8")
	public BaseResponse getMovieList(MovieCondition movieCondition) {
		BaseResponse response = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("formTime", movieCondition.getFromTime());
		map.put("count", movieCondition.getCount());
		map.put("category", movieCondition.getCategory());
		map.put("type", movieCondition.getType());
		map.put("subtype", movieCondition.getSubtype());
		String strResult = restTemplate.postForObject(
				EnumServerMap.getUrlByTag(Constants.TAG_MOVIE) + "/APIV3/Article/GetList", map, String.class);
		List<MovieListBean> list = null;
		try {
			list = JSON.parseArray(strResult, MovieListBean.class);
			if (list == null || list.isEmpty()) {// 查询结构为空
				response = BaseResponse.N(false, EnumCodeInfo.查询结果为空);
			} else {
				MovieNostalgiaBean nostalgiaBean = new MovieNostalgiaBean();
				nostalgiaBean.setMovies(list);
				response = BaseResponse.Y(nostalgiaBean, EnumCodeInfo.操作成功);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response = BaseResponse.N(false, EnumCodeInfo.查询失败, e.getMessage());
		}
		return response;
	}

	/**
	 * @desc 根据id获得电影详情
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getMovieDetailById/{userSid}/{id}", produces = "application/json;charset=UTF-8")
	public BaseResponse getMovieDetailById(@PathVariable("userSid") Integer userSid, @PathVariable("id") Integer id) {
		BaseResponse response = null;
		String strResult = restTemplate.getForObject(
				EnumServerMap.getUrlByTag(Constants.TAG_MOVIE) + "/Article/Detailv2?id=" + id, String.class);
		if (strResult == null || strResult.isEmpty()) {
			response = BaseResponse.N(EnumCodeInfo.查询失败);
		} else {
			MovieDetailBean detailBean = new MovieDetailBean();
			detailBean.setWebInfo(strResult);
			// 查询是否收藏
			detailBean.setCollected(movieIsCollected(userSid, id));
			response = BaseResponse.Y(detailBean, EnumCodeInfo.操作成功);
		}
		return response;
	}

	/**
	 * @desc 根据userSid 和 mvId判断用户是否收藏过
	 * @param userSid
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/mvIsCollected/{userSid}/{id}", produces = "application/json;charset=UTF-8")
	public boolean movieIsCollected(@PathVariable("userSid") Integer userSid, @PathVariable("id") Integer id) {
		boolean isCollected = collectService.isCollect(userSid, id);
		return isCollected;
	}

	/**
	 * 保存到我的收藏
	 * 
	 * @param mvListBean
	 */
	@RequestMapping(value = "/saveToCollections/{userSid}", produces = "application/json;charset=UTF-8")
	public BaseResponse saveToCollections(@PathVariable("userSid") int userSid, @RequestBody MvCollectionBean record) {
		int responseCode = collectService.saveToCollections(userSid, record);
		BaseResponse response = null;
		switch (responseCode) {
		case -3:
			response = BaseResponse.N(EnumCodeInfo.操作失败, "已收藏");
			break;
		case 1:
			response = BaseResponse.N(EnumCodeInfo.操作成功, "收藏成功");
			break;
		default:
			response = BaseResponse.N(EnumCodeInfo.操作失败);
			break;
		}
		return response;
	}

	/**
	 * @desc 获得排片数据
	 * @param timestamp
	 * @return
	 */
	@RequestMapping(value = "getMvPieces", produces = "application/json;charset=UTF-8")
	public BaseResponse getMvPieces(String timestamp) {
		BaseResponse response = null;
		String strResult = restTemplate.getForObject(
				EnumServerMap.getUrlByTag(Constants.TAG_MOVIE) + "/MovieSheet/GetDataByDate?timestamp=" + timestamp,
				String.class);
		if (strResult != null && !StringUtils.isEmpty(strResult)) {
			List<MvPieceBean> pieceList = JSON.parseArray(strResult, MvPieceBean.class);
			MvPiecesBean piecesBean = new MvPiecesBean();
			piecesBean.setPieces(pieceList);
			response = BaseResponse.Y(piecesBean, EnumCodeInfo.操作成功);
		} else {
			response = BaseResponse.N(EnumCodeInfo.查询失败);
		}
		return response;
	}

	/**
	 * 根据userSid获得所有收藏的数据
	 */
	@RequestMapping(value = "getCollectedMvList/{userSid}", produces = "application/json;charset=UTF-8")
	public BaseResponse getCollectedMvList(@PathVariable("userSid") Integer userSid) {
		BaseResponse response = null;
		MvCollectionList mvList = collectService.getAllCollectedList(userSid);
		response = BaseResponse.Y(mvList, EnumCodeInfo.操作成功);
		return response;
	}

	/**
	 * @desc 分页查询收藏的数据
	 * @param userSid
	 * @param index
	 * @param count
	 */
	@RequestMapping(value = "getCollectedByIndex/{userSid}", produces = "application/json;charset=UTF-8")
	public BaseResponse selectCollectedByIndex(@PathVariable("userSid") Integer userSid, int index, int count) {
		BaseResponse response = null;
		MvCollectionList mvList = collectService.getCollectedByIndex(userSid, index, count);
		if (mvList.getCollections().size() == 0) {
			response = BaseResponse.N(EnumCodeInfo.查询结果为空);
		} else {
			response = BaseResponse.Y(mvList, EnumCodeInfo.操作成功);
		}
		return response;
	}
}
