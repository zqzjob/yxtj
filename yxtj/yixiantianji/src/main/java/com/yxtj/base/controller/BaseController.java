package com.yxtj.base.controller;

import java.beans.PropertyEditorSupport;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.yxtj.common.Page;

@Controller
public class BaseController <T> {
    @InitBinder
    public void initBinder( WebDataBinder binder , final HttpServletRequest request ){
        binder.registerCustomEditor(Page.class,new PropertyEditorSupport(){
            @Override
            public Object getValue() {
                Page<T> page = (Page<T>) super.getValue();
                //提前操作  Page 对象
                if ( page.getPage() == null ) {
                    //没有设页数的时候 默认第一页
                    page.setPage(1);
                }
                //设置每页的条数
                page.setSize(5);
                //解析request ，获得请求连接
                String url = request.getRequestURI();
                String params = request.getQueryString();//获取参数
                //忽略掉一已经没用的参数，url变成"http://localhost:8080/SSM/stu/queryByPage?1=1"
                //所以页面中对page传参直接写：&参数=值 接上新的参数即可
                if ( params!=null && !"".equals(params) ) {
                    url += "?" + params;
                }else {
                    url += "?1=1";
                }
                //找到 每次要访问的地址
                int index = -1;
                if ( (index = url.indexOf("&page="))!=-1 ) {
                    url = url.substring(0, index);
                }
                page.setUrl(url);
                return page;
            }
        });
    }
}
