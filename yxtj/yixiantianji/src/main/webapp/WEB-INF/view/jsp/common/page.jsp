<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    <div>
        <c:if test="${page.page==1 }">
            <a>首页</a>
            <a>上一页</a>
        </c:if>
        <c:if test="${page.page>1 }">
            <a href="${page.url }&page=1">首页</a>
            <a href="${page.url }&page=${page.page-1}">上一页</a>
        </c:if>

        <!-- 页码 -->
        <c:forEach items="${page.indexs }" var="index">        
            <c:if test="${index == page.page }">
                <b>${index}</b>
            </c:if>
            <c:if test="${index != page.page }">
                <a href="${page.url }&page=${index}"><b>${index}</b></a>
            </c:if>
        </c:forEach>

        <c:if test="${page.page<page.max }">
            <a href="${page.url }&page=${page.page+1}">下一页</a>
            <a href="${page.url }&page=${page.max}">尾页</a>
        </c:if>
        <c:if test="${page.page==page.max }">
            <a >下一页</a>
            <a >尾页</a>
        </c:if>

        <a>当前第${page.page }页/共${page.max }页</a>     
    </div>