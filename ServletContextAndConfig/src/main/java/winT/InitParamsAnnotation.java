package winT;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
@WebServlet(urlPatterns = "/InitParamsAnnotation",initParams = {
        @WebInitParam(name = "title",value = "Init parameter Annotation Demo"),
        @WebInitParam(name = "configStyle",value = "Annotation")
})
public class InitParamsAnnotation extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("title: "+ getServletConfig().getInitParameter("title"));
        System.out.println("config style " + getInitParameter("configStyle"));
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter print=resp.getWriter();
        System.out.println(getServletConfig());
        print.println("<html><body> Current time "+ LocalDateTime.now()+"</body></html>");
        print.println("title: "+ getServletConfig().getInitParameter("title"));
        print.println("<br>");
        print.println("config style " + getInitParameter("configStyle"));
        print.println("</body></html>");
    }
}
