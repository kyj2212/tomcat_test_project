package com.yejin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        //super.doGet(req, resp);

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        Rq rq = new Rq(req,resp);

        rq.appendBody("<title>구구단</title>");

        int dan = rq.getIntParam("dan",9);
        int limit = rq.getIntParam("limit",9);
        rq.appendBody("<h1>%d단</h1>\n".formatted(dan));
        for(int i=1;i<=limit;i++)
         rq.appendBody("<div>"+dan+"*"+i+"="+dan*i+"</div>");

    }
}


class Rq {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public Rq(HttpServletRequest req, HttpServletResponse resp) {
        this.req=req;
        this.resp=resp;
    }


    public int getIntParam(String param, int defaultValue) {
        String value = req.getParameter(param);

        if(value==null)
            return defaultValue;
        try {
            return Integer.parseInt(value);
        }catch (NumberFormatException e){
            return defaultValue;
        }
    }

    public void appendBody(String str) {
        try{
            resp.getWriter().append(str);
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}