package com.yejin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public Rq(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
    }


    public int getIntParam(String param, int defaultValue) {
        String value = req.getParameter(param);

        if (value == null)
            return defaultValue;
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public void appendBody(String str) {
        try {
            resp.getWriter().append(str);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public void setAttr(String name, Object value){
        req.setAttribute(name,value);
    }

    public void view(String path){
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/"+path+".jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            System.out.println("/jsp/"+path+".jsp 없음");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getMethod(){
        return req.getMethod();
    }

    public String getPath() {
        return req.getRequestURI();
    }

    public String getParam(String param,String defaultValue) {
        String value = req.getParameter(param);

        if (value == null)
            return defaultValue;
        try {
            return value;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
