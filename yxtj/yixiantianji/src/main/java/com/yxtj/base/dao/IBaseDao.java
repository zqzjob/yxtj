package com.yxtj.base.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IBaseDao <T> {

    List<HashMap<Object, Object>> queryOne( @Param("name") String name,@Param("id")int id );

    List<HashMap<Object, Object>> queryAll( @Param("name") String name );

    int add( @Param("name")String name ,@Param("params") Object ...params );

    void update ( @Param("id") int id, @Param("name") String name, @Param("params")Object []params );

    void del(@Param("name")String lowerCase, @Param("id")int id);
    
    List<HashMap<Object, Object>> queryByPage(
            @Param("name")String name, 
            @Param("page")int page, 
            @Param("size")int size,
            String where);

    int queryCount( @Param("name")String lowerCase , @Param("where") String where);
}
