import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//输入url为http://localhost:8080/mytomcat_war_exploded/hello World
public class HelloWorld extends HttpServlet {
    private String message;
    //初始化
    public void init() throws ServletException{
        message="hello World";
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");//定义网址类型
        PrintWriter out=response.getWriter();//在页面上打印输出
        out.println("<h1>"+message+"</h1>");
    }
    //结束Servlet
    public void destroy(){
        super.destroy();
    }
}
