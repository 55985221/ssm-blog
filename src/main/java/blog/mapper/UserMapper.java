package blog.mapper;

import blog.entity.User;

public interface UserMapper {
User getUserByNameOrEmail(String name);
}
