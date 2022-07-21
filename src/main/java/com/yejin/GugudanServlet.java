package com.yejin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().append("<title>구구단</title>");

        int dan = Integer.parseInt(req.getParameter("dan"));
        //System.out.println(dan+"단");
        resp.getWriter().append("<h1>"+dan+"단</h1>");
        resp.getWriter().append("<div>");
        for(int i=1;i<=dan;i++)
            resp.getWriter().append("<div>"+dan+"*"+i+"="+dan*i+"</div>");

    }
}