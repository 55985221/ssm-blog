package blog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import blog.entity.Article;
import blog.entity.Category;
import blog.entity.Tag;
import blog.entity.User;
import blog.service.ArticleService;
import blog.service.CategoryService;
import blog.service.TagService;
import cn.hutool.http.HtmlUtil;
@Controller
@RequestMapping("/article")
public class ArticleController {
	@Resource(name="tagServiceImpl")
	TagService tagservice;
	@Resource(name="categoryServiceImpl")
	CategoryService categoryservice;
	@Resource(name="articleServiceImpl")
	ArticleService articlesercie;
@RequestMapping("/article_list")
public String ArticleList(@RequestParam(required=false,defaultValue="1") Integer pageIndex,@RequestParam(required=false,defaultValue="10")Integer pageSize,  ModelMap m) {
	PageInfo<Article> articePageInfo= articlesercie.getPageArticle(pageIndex,pageSize);
	m.put("pageUrlPrefix", "article/article_list?pageIndex");  //把前缀数据传给分页页面
	m.put("pageInfo",articePageInfo);
	return "article/articleall";
}
@RequestMapping(value="/articleadd",method = RequestMethod.GET)
public String ArticleAdd(Map map) {
	Tag[] tag=tagservice.gatTag();
	 Category[] category=categoryservice.getCategoryByPid();
	map.put("tag", tag);
	map.put("category", category);
	return "article/articleadd";
}
@RequestMapping(value="/articleadd",method = RequestMethod.POST)
public String ArticleAdd(HttpServletRequest request) {
	Article article=new Article();
	
	//当前用户的id
	User user=(User)request.getSession().getAttribute("session_user");
	article.setArticleUserId(user.getUserId());
	
	//文章标题
	article.setArticleTitle(request.getParameter("articleTitle"));
	
	//文章内容
	article.setArticleContent(request.getParameter("articleContent"));
	
	//文章摘要 HtmlUtil是 hutu 工具包提供的一个类
	String s= HtmlUtil.cleanHtmlTag(article.getArticleContent());
	article.setArticleSummary(s.length()>150?s.substring(0,150):s);
	
	//文章发布时间,修改时间
	article.setArticleCreateTime(new Date());
	article.setArticleUpdateTime(new Date());

	article.setArticleCommentCount(0);
	article.setArticleLikeCount(0);
	article.setArticleViewCount(0);
	
	//默认的排序
	article.setArticleOrder(1);
	
	//文章状态(草稿,或发布)
	article.setArticleStatus(Integer.parseInt(request.getParameter("articleStatus" )));

	//一级分类ID
	int parentCateId =Integer.parseInt(request.getParameter("articleParentCategoryId"));
	
	//二级分类ID
	int childCateId=Integer.parseInt(request.getParameter("articleChildCategoryId"));
	
	//标签
	String [] tagIds =request.getParameterValues("articleTagIds");
	
	//把分类信息 交给article
	List<Category>categoryList=new ArrayList<>(2);
	categoryList.add(new Category(parentCateId));

	categoryList.add(new Category(childCateId));
	article.setCategoryList(categoryList);
	
	//把标签信息,交给article
	List<Tag> tagList=new ArrayList<>();
	for(String tagId:tagIds) {
		tagList.add(new Tag(Integer.parseInt(tagId)));
	}
	article.setTagList(tagList);
	
	//调用业务层,进行文章发布
	articlesercie.ArticleAdd(article);
	
	//forward 或  redirect 不受前后缀的影响
	return "forward:/article/article_list";
}
}
