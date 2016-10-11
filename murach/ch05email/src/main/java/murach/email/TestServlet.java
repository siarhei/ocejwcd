package murach.email;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="MurachTestServlet", urlPatterns={"/test", "/test2/*"})
public class TestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");        
        PrintWriter out = response.getWriter();        
        try {
            out.println("<h1>HTML from annotated servlet</h1>");
            out.printf("<p>Please contact %s</p>", getServletContext().getInitParameter("custServEmail"));
        } 
        finally {
            out.close();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }    
}