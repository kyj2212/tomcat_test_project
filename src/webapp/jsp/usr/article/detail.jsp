<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.yejin.article.dto.ArticleDto" %>
<%@ page import="java.util.Date" %>

<title>게시물</title>
<h1>게시물</h1>

<% ArticleDto article = (ArticleDto) request.getAttribute("article");%>
<div>
<%
if(article!= null){ %>
        <div>
            ID : <%=article.getId()%>
        </div>
        <div>
            TITLE : <%=article.getTitle()%>
        </div>
        <div>
            BODY : <%=article.getBody()%>
        </div>
<%} %>
<div class="btn">
<button class="third">
<a href ="/usr/article/list/free>"> 자유게시판 목록 </a>
</button>
</div>
</html>