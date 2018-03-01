package com.yxtj.user.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yxtj.base.dao.IBaseDao;
import com.yxtj.user.vo.User;

public interface IUserDao extends IBaseDao<User> {

	Map<Object, Object> getUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

}
