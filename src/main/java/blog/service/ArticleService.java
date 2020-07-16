package blog.service;

import java.util.List;

import blog.entity.Article;

public interface ArticleService {
List<Article> listRecentArticle(Integer n); 
}
