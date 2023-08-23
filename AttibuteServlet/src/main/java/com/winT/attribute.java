package com.winT;

import com.sun.net.httpserver.HttpContext;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/attribute")
public class attribute extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpServlet
//        HttpSession
//        ServletContext
        req.setAttribute("","");
        req.getAttribute("");
        req.removeAttribute("");

        HttpSession session=req.getSession();
        session.getAttribute("");
        session.setAttribute("","");
        session.removeAttribute("");

        ServletContext servletContext=this.getServletContext();
        servletContext.getAttribute("");
        servletContext.setAttribute("","");
        servletContext.removeAttribute("");
    }
}
