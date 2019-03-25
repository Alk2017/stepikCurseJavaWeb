package servlets;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MirrorRequestsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> pageVariables = new HashMap<>();

        String key = request.getParameter("key");

        if (key == null|| key=="")
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        else {
            response.setStatus(HttpServletResponse.SC_OK);
            //pageVariables.put("key", key);
            //response.getWriter().println(PageGenerator.getInstance().getPage("pageWithValue.html", pageVariables));
            response.getWriter().println(key);
        }


        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
    }

}
