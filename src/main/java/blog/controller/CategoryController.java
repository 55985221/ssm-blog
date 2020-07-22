package blog.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.entity.Category;
import blog.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Resource(name="categoryServiceImpl")
	CategoryService  categoryservice; 
	@RequestMapping("/all")
	public String getcategoryall(Map map) {
		Category[] category=categoryservice.getCategoryByPid();
	map.put("category", category);
		return "/category/categoryall";
	}
}
