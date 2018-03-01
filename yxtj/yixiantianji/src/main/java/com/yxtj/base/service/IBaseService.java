package com.yxtj.base.service;

import java.util.List;

import com.yxtj.common.Page;

public interface IBaseService <T>{
    void del( int id );
    List<T> queryAll();
    int add( T t );
    void update ( T t );
	T queryOne(int id);
	Page<T> queryByPage(Page<T> page);
}
