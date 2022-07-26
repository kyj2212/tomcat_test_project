<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.yejin.article.dto.ArticleDto" %>
<%@ page import="java.util.Date" %>

<style>
@charset "utf-8";
/* 공통옵션 */
ul li {list-style:none; }
.fl {float:left; }
.tc {text-align:center; }

/* 게시판 목록 */
.board {width: 950px;
display:inline-block;}
.w70 {width:70px; }
.w500 {width:500px; }
.w120 {width:120px; }
.w100 {width:100px; }
.w300 {width:300px; }
.title {
	height: 50px;
	line-height: 50px;
	background:skyblue;
	font-weight: bold;
}
.t_line {border-right:solid 1px gray;}
.lt_line {border-bottom:solid 1px gray;}
.list {
	height: 40px;
	line-height: 40px;
	background: #f3f3f3;
}
</style>
<html>
<title>게시물 목록</title>
<h1>게시물 목록</h1>
<%
//ArticleDto articlea = new ArticleDto(1,"본문","제목",new Date());
//System.out.println(articlea);
%>

<%List<ArticleDto> articles = (List)request.getAttribute("articles");%>
<ul class="board">
<li class="fl tc w70 title t_line lt_line">ID</li>
<li class="fl tc w100 title t_line lt_line">TiTle</li>
<li class="fl tc w200 title t_line lt_line">BODY</li>
<li class="fl tc w300 title t_line lt_line">DATE</li>
</ul>
<%for( ArticleDto article : articles) {%>
<ul class="board">
<li class="fl tc w70 list t_line lt_line"><%=article.getId()%></li>
<li class="fl tc w100 list t_line lt_line"><%=article.getTitle()%></li>
<li class="fl tc w200 list t_line lt_line"><%=article.getBody()%></li>
<li class="fl tc w300 list t_line lt_line"><%=article.getDate()%></li>

</ul>
<% } %>

</html>