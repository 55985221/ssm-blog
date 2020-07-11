package blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.entity.User;
import blog.mapper.UserMapper;
import blog.service.UserService;
@Service
public class UserServiceImpl implements UserService{
@Resource
/*
 *   getUserByNameOrEmail 根据邮箱和用户名查询用户 返回user
 * 
 * */
private UserMapper usemapper;
public User getUserByNameOrEmail(String name) {
	
	return usemapper.getUserByNameOrEmail(name);
}
}
