package wint.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@WebServlet("/result")
public class result extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        Cookie[] cookieServlet=req.getCookies();
        out.println("<html><body> day la trang dich ");
        out.println("username :"+this.getValueInCookie(cookieServlet,"user").get());
        out.println("password :"+this.getValueInCookie(cookieServlet,"playlist").get());
        out.println("</body></html>");
    }
    private Optional<String> getValueInCookie(Cookie[] cookies, String name){
        return Stream.of(cookies)
                .filter(cookie -> name.equals(cookie.getName()))
                .map(Cookie::getValue).findAny();
    }
}
