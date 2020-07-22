package blog.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import blog.entity.Article;

public interface ArticleService {
List<Article> listRecentArticle(Integer n); 
PageInfo<Article> getPageArticle(Integer pageIndex,Integer pageSize);
void ArticleAdd(Article article);
}
