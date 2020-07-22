package blog.service;

import blog.entity.Category;

public interface CategoryService {
	Category[]  getCategoryByPid();
	Category[] getCategory();
}
