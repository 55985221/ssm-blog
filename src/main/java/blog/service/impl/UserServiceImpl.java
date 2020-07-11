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
 *   getUserByNameOrEmail ����������û�����ѯ�û� ����user
 * 
 * */
private UserMapper usemapper;
public User getUserByNameOrEmail(String name) {
	
	return usemapper.getUserByNameOrEmail(name);
}
}
