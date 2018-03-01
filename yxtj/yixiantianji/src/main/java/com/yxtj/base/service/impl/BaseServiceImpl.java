package com.yxtj.base.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxtj.base.dao.IBaseDao;
import com.yxtj.base.service.IBaseService;
import com.yxtj.common.Page;

@Service
@Transactional
public abstract class BaseServiceImpl<T> implements IBaseService<T>{
    //提供一个抽象方法 当前类的子类需要提供具体实现类的 Dao 
    public abstract IBaseDao<T> getBaseDao(); 
    //提供一个抽象方法  当前类的子类需要提供 entity的 Class 对象
    public abstract Class<T> getClasss();

    public Class<T> clsss;
    {
        clsss = getClasss();
    }

    /**
    * 根据 id 查找一个对象
    */
    @Override
    public T queryOne(int id) {
        String name = clsss.getSimpleName().toLowerCase();
        Map<Object, Object> map =  getBaseDao().queryOne(name,id).get(0);
        T t = hashMapToEntity(map);
        return t;
    }
    /**
    * 查找所有对象
    */
    @Override
    public List<T> queryAll() {
        List<T> ts = new ArrayList<>();
        String name = clsss.getSimpleName().toLowerCase();
        List<HashMap<Object, Object>> list =  getBaseDao().queryAll( name );
        for (HashMap<Object, Object> hashMap : list) {
            ts.add( hashMapToEntity( hashMap ) );
        }
        return ts;
    }

    /**
    * 添加一个 对象
    */
    @Override
    public int add(T t) {
        //获取表名
        String tableName = clsss.getSimpleName().toLowerCase();
        List<Object> list= new ArrayList<>();
        //将参数放入数组中
        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);//权限
            try {
                list.add(field.get(t));
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return getBaseDao().add( tableName , list.toArray() );
    }

    /**
    * 更新一个对象
    */
    @Override
    public void update(T t) {
        int id = 0;
        String tableName = clsss.getSimpleName().toLowerCase();
        List<Object> list= new ArrayList<>();
        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);//权限
            try {
                if ( field.get(t) == null ) {
                    continue;
                }
                if (("id").equals( field.getName()) ) { 
                    id = (Integer) field.get(t);
                    continue ;
                }
                //拼接成 ：变量名='值' 的形式
                list.add( field.getName()+"="+ "'" + field.get(t) + "'" );
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        getBaseDao().update( id, tableName , list.toArray() );

    }
    /**
    * 根据id 删除 一个对象
    */
    @Override
    public void del(int id) {
        String name = clsss.getSimpleName();
        name = name.toLowerCase();
        getBaseDao().del(name, id);
    }  
    
    /**
     * 将HashMap 转成 实体类对象
     */
    public T hashMapToEntity( Map<Object, Object> map ) {
        T t = null;
        try {
            t = clsss.newInstance();
            for (Field f : t.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                f.set(t,map.get(f.getName()));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return t;
    }
    
    //无条件查询记录数
    public int queryCount() {
        String tableName = clsss.getSimpleName().toLowerCase();
        return getBaseDao().queryCount( tableName , "1=1" );
    }
    //有条件的查找记录数
    public int queryCount(String where) {
        String tableName = clsss.getSimpleName().toLowerCase();
        return getBaseDao().queryCount( tableName , where );
    }
    
    @Override
    public Page<T> queryByPage(Page<T> page) {
        String tableName = clsss.getSimpleName().toLowerCase();
        List<T> list = new ArrayList<>();
        //分页 查询 数据   (表名，分页起始位置(利用mysql的limit),每页条数,[条件]) 
        List<HashMap<Object, Object>> listmap =  getBaseDao().queryByPage( tableName, 
                    (page.getPage()-1)*page.getSize() , page.getSize(),
                    page.getWhere() );
        // 遍历每个 Map 并通过自定义的方法转换成目标实体类，并添加到结果集list中
        for (HashMap<Object, Object> hashMap : listmap) {
            T t1 = hashMapToEntity(hashMap);
            list.add( t1 );
        }
        //将转换好的数据集合放入 Page 对象
        page.setList(list);
        //根据条件查询数据条数
        if ( page.getWhere()==null || page.getWhere().length()<=0 ) {
            page.setCount( queryCount(  ) );
        }else {
            page.setCount( queryCount( page.getWhere() ) );
        }
        //数据总条数
        int tmp = page.getCount()/page.getSize();
        //最大页数
        page.setMax(page.getCount()<=page.getSize()?1:page.getCount()%page.getSize()>0?tmp+1:tmp);
        return page;
    }
}
