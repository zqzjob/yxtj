package com.yxtj.user.service;

import com.yxtj.base.service.IBaseService;
import com.yxtj.user.vo.User;

public interface IUserService extends IBaseService<User> {
	public User login(String username,String password);
}
