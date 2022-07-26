package com.yejin.article;

import com.yejin.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleRepository {

    private static ArticleRepository instance;
    private static List<ArticleDto> articleDtoList;

    private static long lastId;

/*
    static {
        articleDtoList=new ArrayList<>();
        lastId=0;
    }
*/

    private ArticleRepository(){
        articleDtoList=new ArrayList<>();
        lastId=0;
    }

    public static ArticleRepository getInstance(){
        if(instance==null)
            instance=new ArticleRepository();
        return instance;
    }




    public long write(String title, String body){
        long id = ++lastId;
        ArticleDto newArticleDto = new ArticleDto(id,title,body,  new Date());
        articleDtoList.add(newArticleDto);
        return id;
    }

    public List<ArticleDto> list() {
        return articleDtoList;
    }
}
