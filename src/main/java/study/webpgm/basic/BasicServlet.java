package study.webpgm.basic;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "basicServlet", urlPatterns = "/basic")
    public class BasicServlet extends HttpServlet {
        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
            System.out.println("BasicServlet Called!!!");

            Enumeration<String> names = request.getParameterNames();
            while(names.hasMoreElements()) {
                String key = (String) names.nextElement();
                System.out.println(key + ": " + request.getParameter(key));
            }

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");

            PrintWriter pw = response.getWriter();
            pw.write("<html>\n" +
                    "<body>\n" +
                    "username= "+ username +"<br>\n" +
                    "password= "+ password +"<br>\n" +
                    "</body>\n" +
                    "</html>");
        }
    }

