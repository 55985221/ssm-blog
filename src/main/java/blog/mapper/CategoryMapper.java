package blog.mapper;

import blog.entity.Category;

public interface CategoryMapper {
	Category[] 	getCategoryByPid(Integer id);
	Category[] getCategory();
}
