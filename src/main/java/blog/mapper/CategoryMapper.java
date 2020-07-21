package blog.mapper;

import blog.entity.Category;

public interface CategoryMapper {
	Category[] 	GetCategoryByPid(Integer id);
}
