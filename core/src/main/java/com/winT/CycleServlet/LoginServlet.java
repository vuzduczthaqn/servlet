package com.winT.CycleServlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LoginServlet extends HttpServlet {
    public LoginServlet(){
        System.out.println("LoginServlet constructor is being called");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init()....being called");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<html><body>"+"current time "+ LocalDateTime.now());
        out.println("</body></html>");

    }

    @Override
    public void destroy() {
        System.out.println("destroy()... being called");
    }
}
