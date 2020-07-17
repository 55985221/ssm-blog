package blog.mapper;

import java.util.List;

import blog.entity.Article;

public interface ArticleMapper {
	public List<Article> listRecentArticle(Integer n);
	public Article getArticleByid(Integer id);
	public List<Article> gindall();
}
