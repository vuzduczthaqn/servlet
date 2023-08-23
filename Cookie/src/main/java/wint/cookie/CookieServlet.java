package wint.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie=new Cookie("user","winT");
        cookie.setMaxAge(60*10);//10 minute
        resp.addCookie(cookie);

        Cookie playlist=new Cookie("playlist","ListServlet");
        resp.addCookie(playlist);
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<html><body>");
        out.println("<a href=\"result\">Go to the result</a>");
        out.println("</body></html>");
    }
}
