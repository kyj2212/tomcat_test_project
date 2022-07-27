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
.w100 {width:100px; }
.w200 {width:200px; }
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
	height: 80px;
	line-height: 40px;
	background: #f3f3f3;
}
.btn {
  box-sizing: border-box;
  appearance: none;
  background-color: transparent;
  border: 2px solid $red;
  border-radius: 0.6em;
  color: $red;
  cursor: pointer;
  display: flex;
  align-self: center;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1;
  margin: 20px;
  padding: 1.2em 2.8em;
  text-decoration: none;
  text-align: center;
  text-transform: uppercase;
  font-family: 'Montserrat', sans-serif;
  font-weight: 700;

  &:hover,
  &:focus {
    color: #fff;
    outline: 0;
  }

}
h1 {
  color: #f1c40f;
  font-size: 4rem;
  text-transform: uppercase;
  display: block;
  width: 100%;
  text-align: center;

  @media screen and (max-width: 600px) {
    font-size: 3rem;
  }
}


.third {
  border-color: #3498db;
  color: #fff;
  box-shadow: 0 0 40px 40px $blue inset, 0 0 0 0 #3498db;
  transition: all 150ms ease-in-out;
  display: block;
  text-align: center;
  &:hover {
    box-shadow: 0 0 10px 0 $blue inset, 0 0 10px 4px #3498db;
  }
}
</style>
<html>
<title>게시물 목록</title>
<h1>게시물 목록</h1>
<%
//

//ArticleDto articles = new ArticleDto(1,"본문","제목",new Date());
//System.out.println(articles);
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
<li class="fl tc w70 list t_line lt_line">
<a href ="/usr/article/detail/free/<%=article.getId()%>"><%=article.getId()%>(/id)</a>
<a href ="/usr/article/content/free?id=<%=article.getId()%>"><%=article.getId()%>(/id=id)</a>
</li>
<li class="fl tc w100 list t_line lt_line"><%=article.getTitle()%></li>
<li class="fl tc w200 list t_line lt_line"><%=article.getBody()%></li>
<li class="fl tc w300 list t_line lt_line"><%=article.getDate()%></li>

</ul>

<% } %>
<div class="btn">
<button class="third">
<a href ="/usr/article/write/free>"> 자유게시판 글쓰기 </a>
</button>
</div>
</html>