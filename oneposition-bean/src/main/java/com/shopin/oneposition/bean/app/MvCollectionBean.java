package com.shopin.oneposition.bean.app;

import java.util.Date;

public class MvCollectionBean extends BaseEntity {
    private Integer sid;

    private Integer userSid;

    private Integer id;

    private String title;

    private String engname;

    private String summary;

    private Date createTime;

    private Date collectTime;

    private String location;

    private String pic;

    private String pics;

    private Boolean istopic;

    private String type;

    private String tag;

    private Integer category;

    private Integer commentcount;

    private Integer sharecount;

    private String prize;

    private Integer wantwatchnums;

    private Integer unwantwatchnums;

    private Integer picscount;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUserSid() {
        return userSid;
    }

    public void setUserSid(Integer userSid) {
        this.userSid = userSid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getEngname() {
        return engname;
    }

    public void setEngname(String engname) {
        this.engname = engname == null ? null : engname.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics == null ? null : pics.trim();
    }

    public Boolean getIstopic() {
        return istopic;
    }

    public void setIstopic(Boolean istopic) {
        this.istopic = istopic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(Integer commentcount) {
        this.commentcount = commentcount;
    }

    public Integer getSharecount() {
        return sharecount;
    }

    public void setSharecount(Integer sharecount) {
        this.sharecount = sharecount;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize == null ? null : prize.trim();
    }

    public Integer getWantwatchnums() {
        return wantwatchnums;
    }

    public void setWantwatchnums(Integer wantwatchnums) {
        this.wantwatchnums = wantwatchnums;
    }

    public Integer getUnwantwatchnums() {
        return unwantwatchnums;
    }

    public void setUnwantwatchnums(Integer unwantwatchnums) {
        this.unwantwatchnums = unwantwatchnums;
    }

    public Integer getPicscount() {
        return picscount;
    }

    public void setPicscount(Integer picscount) {
        this.picscount = picscount;
    }
}