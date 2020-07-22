package blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import blog.entity.Article;

public interface ArticleMapper {
	public List<Article> listRecentArticle(Integer n);
	public Article getArticleByid(Integer id);
	public List<Article> gindall();
	public void  ArticleAdd(Article article);
	void addArticleCategory(@Param("articleId")Integer articleId,@Param("categoryId")Integer categoryId);
	void addArticleTag(@Param("articleId")Integer articleId,@Param("tagId")Integer tagId);
}
