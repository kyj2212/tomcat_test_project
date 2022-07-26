package com.yejin.article;

import com.yejin.article.dto.ArticleDto;

import java.util.List;

public class ArticleService {

    private ArticleRepository articleRepository;

    ArticleService(){
        //articleRepository = new ArticleRepository();
        articleRepository = ArticleRepository.getInstance();
    }

    public long write(String title, String body){

        return articleRepository.write(title,body);
    }

    public List<ArticleDto> list() {
        return articleRepository.list();
    }
}
