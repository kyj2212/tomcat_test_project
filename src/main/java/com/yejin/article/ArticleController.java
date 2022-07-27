package com.yejin.article;

import com.yejin.Rq;
import com.yejin.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleController {


    private ArticleService articleService;
    private List<ArticleDto> articleDtos;

    public ArticleController(){
        articleService=new ArticleService();
    }

    public void showList(Rq rq) {


       // System.out.println("showlist");
        List<ArticleDto> articleDtos = articleService.findAll();
        rq.setAttr("articles",articleDtos);
        rq.view("/usr/article/list");

    }
    public void addList(List<ArticleDto> articleDtos){
        for(int i=1;i<6;i++){
            articleDtos.add(new ArticleDto(i,("제목"+i),("내용"+i), new Date()));
        }
    }

    public void showWrite(Rq rq) {
       // System.out.println("showwrite");
        rq.view("/usr/article/write");
    }

    public void list(Rq rq){
        articleDtos=articleService.list();
        rq.setAttr("articles",articleDtos);
        rq.view("/usr/article/list");
    }

    public void doWrite(Rq rq) {
      //  System.out.println("dowrite");
        String title= rq.getParam("title","");
        String body = rq.getParam("body","");

        // title,body 값이 없는 경우 앞단의 jsp 에서 js를 통해 이미 체크함
        long id = articleService.write(title,body);
        rq.appendBody("<div>%d 번 게시물이 등록되었습니다.</div>".formatted(id));
        rq.appendBody("<div>title : %s</div>".formatted(title));
        rq.appendBody("<div>body : %s</div>".formatted(body));
        //rq.appendBody("<li><a href =\"/usr/article/detail/free/%d\">%d</a></li>".formatted(id,id));



        showList(rq);
    }

    public void showDetail(Rq rq){
        long id = rq.getLongPathValueByIndex(1,0);// url/"" 뒤에 오는 1번째 오는 param  가져오기
        System.out.println(id);
        ArticleDto articleDto = articleService.findById(id);
        rq.setAttr("article",articleDto);
        rq.view("usr/article/detail");
    }

    public void showArticle(Rq rq){
        long id=rq.getLongParam("id",0);
        rq.setAttr("id",id);
        ArticleDto articleDto = articleService.articleAt(id);
        rq.setAttr("article",articleDto);
        rq.view("usr/article/content");
    }

}
