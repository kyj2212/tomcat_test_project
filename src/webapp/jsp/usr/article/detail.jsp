<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.yejin.article.dto.ArticleDto" %>

<%@ include file="../common/head.jspf"%>
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
<button class="block mb-4 px-3 py-2 text-xs font-bold rounded-full no-underline hover:shadow bg-blue-600 text-white"
onclick="location.href='/usr/article/list/free'">자유게시판 목록</button>
<div class="btn">
<button class="block mb-4 px-3 py-2 text-xs font-bold rounded-full no-underline hover:shadow bg-blue-600 text-white"
onclick="location.href='/usr/article/modify/free/<%=article.getId()%>'">게시글 수정</button>
</button>
<button class="block mb-4 px-3 py-2 text-xs font-bold rounded-full no-underline hover:shadow bg-blue-600 text-white"
onclick="location.href='/usr/article/delete/free/<%=article.getId()%>'">게시글 삭제</button>
 <div class="flex justify-between text-xs">
     <a href="#" class="bg-gray text-white no-underline py-2 px-3 rounded" onclick="location.href='/usr/article/modify/free/<%=article.getId()%>'">수정</a>
     <a href="#" class="bg-black text-white no-underline py-2 px-3 rounded" onclick="location.href='/usr/article/delete/free/<%=article.getId()%>'">삭제</a>
 </div>
</div>

<%@ include file="../common/foot.jspf"%>