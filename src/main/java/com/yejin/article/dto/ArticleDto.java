package com.yejin.article.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class ArticleDto {

    private long id;
    private String title;
    private String body;
    private Date date;


    @Override
    public String toString() {
        return "AticleDto{" +
                "id="+id+
                ", title='"+title+'\''+
                ", body='"+body+'\''+
                ", date="+date+
                '}';
    }

    public ArticleDto(int id, String title, String body, Date date){
        this.id=id;
        this.title=title;
        this.body=body;
        this.date=date;
    }

}
