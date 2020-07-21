package blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.entity.Category;
import blog.mapper.CategoryMapper;
import blog.mapper.CategoryrefMapper;
import blog.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
@Resource
	CategoryMapper categorymapper;
@Resource
CategoryrefMapper categoryrefmapper;
public Category[] GetCategoryByPid() {
	      Category[] category= categorymapper.GetCategoryByPid(0);
	      for(int i=0;i<category.length;i++) {
	    	  Category[] catEgory=categorymapper.GetCategoryByPid( category[i].getCategoryid());
	    	  for(int z=0;z<catEgory.length;z++) {
	    		  catEgory[z].setArticlenumber(categoryrefmapper.GetcategoryrefCount(catEgory[z].getCategoryid()));
	    	  }
	    	  category[i].setCategory(catEgory);
	    	  category[i].setArticlenumber(categoryrefmapper.GetcategoryrefCount(category[i].getCategoryid()));
	    	  
	      }
	return category;
}
}
