package com.shopin.oneposition.bean;

import com.shopin.oneposition.bean.app.BaseEntity;

/**
 * @author changePosition
 * @version 2017年7月9日 下午4:17:23
 * @DESC
 */
public class MovieListBean extends BaseEntity {
	private int id;
	private String title;
	private String engname;
	private String summary;
	private String createtime;
	private String location;
	private String pic;
	private String pics;
	private boolean istopic;
	private int type;
	private String tag;
	private int category;
	private int commentcount;
	private int sharecount;
	private float prize;
	private int wantwatchnums;
	private int unwantwatchnums;
	private int picsCount;
	private MovieSubTypeBean subtype;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEngname() {
		return engname;
	}
	public void setEngname(String engname) {
		this.engname = engname;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
	}
	public boolean isIstopic() {
		return istopic;
	}
	public void setIstopic(boolean istopic) {
		this.istopic = istopic;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}
	public int getSharecount() {
		return sharecount;
	}
	public void setSharecount(int sharecount) {
		this.sharecount = sharecount;
	}
	public float getPrize() {
		return prize;
	}
	public void setPrize(float prize) {
		this.prize = prize;
	}
	public int getWantwatchnums() {
		return wantwatchnums;
	}
	public void setWantwatchnums(int wantwatchnums) {
		this.wantwatchnums = wantwatchnums;
	}
	public int getUnwantwatchnums() {
		return unwantwatchnums;
	}
	public void setUnwantwatchnums(int unwantwatchnums) {
		this.unwantwatchnums = unwantwatchnums;
	}
	public int getPicsCount() {
		return picsCount;
	}
	public void setPicsCount(int picsCount) {
		this.picsCount = picsCount;
	}
	public MovieSubTypeBean getSubtype() {
		return subtype;
	}
	public void setSubtype(MovieSubTypeBean subtype) {
		this.subtype = subtype;
	}
	
}
