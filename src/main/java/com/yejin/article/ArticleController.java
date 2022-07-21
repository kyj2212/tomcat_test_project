package com.yejin.article;

import com.yejin.Rq;
import com.yejin.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleController {



    public void showList(Rq rq) {


        List<ArticleDto> articleDtos = new ArrayList<>();
        addList(articleDtos);
        rq.setAttr("articles",articleDtos);

        rq.view("/usr/article/list");

    }
    public void addList(List<ArticleDto> articleDtos){
        for(int i=1;i<6;i++){
            articleDtos.add(new ArticleDto(i,("제목"+i),("내용"+i), new Date()));
        }
    }
}
