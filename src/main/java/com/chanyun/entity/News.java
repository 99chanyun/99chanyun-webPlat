package com.chanyun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("资讯信息")
public class News {
	@ApiModelProperty(value="资讯id",readOnly=true)
    private Integer id;
	@ApiModelProperty(value="资讯头")
    private String newsTitle;
	@ApiModelProperty(value="资讯描述")
    private String newsDescription;
	@ApiModelProperty(value="资讯关键字")
    private String newsKeywords;
	@ApiModelProperty(value="资讯类型 0佛门动态 1政策法规 2佛学入门 3 法会信息 4募捐 5 活动")
    private Integer newsType;
	@ApiModelProperty(value="资讯封面图片路径，图片先上传获取图片路径")
    private String newsImg;
	@ApiModelProperty(value="资讯排序")
    private Integer newsSort;
	@ApiModelProperty(value="资讯状态 1启用 2禁用 99禁用")
    private Integer newsStatus;
	@ApiModelProperty(value="资讯首页推荐 0推荐到首页 1不推荐 默认不推荐",example="1")
    private Integer newsRecommend;
	@ApiModelProperty(value="资讯所属寺庙id",example="1",hidden=true)
    private Integer newsTempleid;
	@ApiModelProperty(value="资讯创建时间")
    private Date createTime;
	@ApiModelProperty(value="资讯来源",example="原创")
    private String newsSource;
	@ApiModelProperty(value="资讯内容")
    private String newsContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription == null ? null : newsDescription.trim();
    }

    public String getNewsKeywords() {
        return newsKeywords;
    }

    public void setNewsKeywords(String newsKeywords) {
        this.newsKeywords = newsKeywords == null ? null : newsKeywords.trim();
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg == null ? null : newsImg.trim();
    }

    public Integer getNewsSort() {
        return newsSort;
    }

    public void setNewsSort(Integer newsSort) {
        this.newsSort = newsSort;
    }

    public Integer getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(Integer newsStatus) {
        this.newsStatus = newsStatus;
    }

    public Integer getNewsRecommend() {
        return newsRecommend;
    }

    public void setNewsRecommend(Integer newsRecommend) {
        this.newsRecommend = newsRecommend;
    }

    public Integer getNewsTempleid() {
        return newsTempleid;
    }

    public void setNewsTempleid(Integer newsTempleid) {
        this.newsTempleid = newsTempleid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource == null ? null : newsSource.trim();
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }
}