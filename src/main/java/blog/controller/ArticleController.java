package blog.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import blog.entity.Article;
import blog.service.ArticleService;
@Controller
@RequestMapping("/article")
public class ArticleController {
	@Resource(name="articleServiceImpl")
	ArticleService articlesercie;
@RequestMapping("/article_list")
public String ArticleList(@RequestParam(required=false,defaultValue="1") Integer pageIndex,@RequestParam(required=false,defaultValue="10")Integer pageSize,  ModelMap m) {
	PageInfo<Article> articePageInfo= articlesercie.getPageArticle(pageIndex,pageSize);
	m.put("pageUrlPrefix", "article/article_list?pageIndex");  //把前缀数据传给分页页面
	m.put("pageInfo",articePageInfo);
	return "Article/article_list";
}
}
