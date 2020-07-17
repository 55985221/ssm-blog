package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import blog.entity.Article;
import blog.mapper.ArticleMapper;
import blog.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {
   @Resource
	ArticleMapper articlemapper;
public List<Article> listRecentArticle(Integer n) {
	return  articlemapper.listRecentArticle(n);
	
}
@Override
	public PageInfo<Article> getPageArticle(Integer pageIndex, Integer pageSize) {
	PageHelper.startPage(pageIndex,pageSize);
	List<Article> article= articlemapper.gindall();
	for(Article art:article) {
		//ÏÈÇ·×Å
	}
	return new PageInfo<Article>(article);
	}
}
