package com.chanyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.common.Constants;
import com.chanyun.common.PageInfo;
import com.chanyun.dao.NewsMapper;
import com.chanyun.entity.News;
import com.chanyun.service.NewsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsMapper mapper;
	
	@Override
	public List<News> queryIndexNewsList() {
		List<News> result = mapper.selectIndexNews();
		return result;
	}

	@Override
	public PageInfo<News> queryNewsList(int pageNum,int pageSize,News news) {
		PageHelper.startPage(pageNum, pageSize);
		PageHelper.orderBy("create_time desc");
		Page<News> sqlResult = mapper.selectNewsByPage(news);
		PageInfo<News> result = new PageInfo<News>(sqlResult);
		return result;
	}

	@Override
	public News add(News news) {
		int i=mapper.insertSelective(news);
		if(i>0) return news;
		return null;
	}

	@Override
	public boolean edit(News news) {
		int i = mapper.updateByPrimaryKeySelective(news);
		if(i>0) return true;
		return false;
	}

	@Override
	public News queryNewsById(int newsId) {;
		News news = mapper.selectByPrimaryKey(newsId);
		return news;
	}

	@Override
	public News queryIndexCeremonies() {
		News news = new News();
		news.setNewsType(Constants.NEWS_TYPE_CEREMONIES);//法会信息
		news.setNewsRecommend(0);//推荐到首页
		List<News> newsList = mapper.selectNewsByParams(news);
		if(null != newsList && newsList.size() > 0) return newsList.get(0);
		return null;
	}

	@Override
	public List<News> queryIndexActivities() {
		News news = new News();
		news.setNewsType(Constants.NEWS_TYPE_ACTIVITY);//线下佛门活动
		news.setNewsRecommend(0);//推荐到首页
		List<News> newsList = mapper.selectNewsByParams(news);
		return newsList;
	}

	@Override
	public List<News> queryNewsByTempleId(int templeId) {
		News news = new News();
		news.setNewsTempleid(templeId);
		List<News> newsList = mapper.selectNewsByParams(news);
		return newsList;
	}

	@Override
	public List<News> queryNewsByTitle(String newsTitle) {
		News news = new News();
		news.setNewsTitle(newsTitle);
		List<News> result = mapper.selectNewsByParams(news);
		return result;
	}
	
	
	
}
