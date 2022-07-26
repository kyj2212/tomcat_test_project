package com.yejin;

import com.yejin.article.ArticleController;
import com.yejin.member.MemberController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Rq rq = new Rq(req,resp);

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();

        String url = req.getRequestURI();

        System.out.println(url);

        switch (url) {
            case "/usr/article/list/free":
                articleController.showList(rq);
                break;
            case "/usr/article/write/free":
                articleController.showWrite(rq);
                break;
            case "/usr/member/login":
                memberController.showLogin(rq);
                break;
        }


    }
}
