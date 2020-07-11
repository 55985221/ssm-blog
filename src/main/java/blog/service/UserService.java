package blog.service;

import blog.entity.User;

public interface UserService {
	User getUserByNameOrEmail(String name);
}
