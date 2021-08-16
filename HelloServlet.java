package com.example.serlvet_jdbc.servlet;
//输入url格式为http://localhost:8080/Serlvet_JDBC_war_exploded/user/（ID号）
import com.example.serlvet_jdbc.dao.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.regex.*;
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "null";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        StringBuffer geturl=request.getRequestURL();
        message=geturl.toString().substring(geturl.toString().lastIndexOf("/")+1);//取得url最后的数字
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        Pattern p=Pattern.compile("[0-9]+");//正则表达式判断是否为数字
        if(!p.matcher(message).matches()){
            out.println("<h1>hello<h1>");
        }else{
            int need_num=Integer.parseInt(message);
            try{
                out.println("<h1>" +new mysqlop().research(need_num) + "</h1>");
            }catch (Exception e) {
                e.printStackTrace();
            }
            out.println("</body></html>");
        }
    }

    public void destroy() {
    }
}