package com.yxtj.user.service.impl;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxtj.base.dao.IBaseDao;
import com.yxtj.base.service.impl.BaseServiceImpl;
import com.yxtj.user.dao.IUserDao;
import com.yxtj.user.service.IUserService;
import com.yxtj.user.vo.User;
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
	@Autowired
    private IUserDao userDao;
	@Override
	public IBaseDao<User> getBaseDao() {
		return userDao;
	}

	@Override
	public Class<User> getClasss() {
		return User.class;
	}

	@Override
	public User login(String username,String password) {
		Map<Object, Object> map = userDao.getUserByUsernameAndPassword(username,password);
		User user = null;
		if(map != null){
			user = hashMapToEntity(map);
		}
		return user;
	}
	
}
