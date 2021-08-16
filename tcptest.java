package tcptestD_R;
import java.io.*;
import java.net.*;
public class tcptest {
    public static void main(String[] args) throws Exception{
        ServerSocket server=new ServerSocket(8848);
        Socket client=null;
        PrintStream ps=null;
        System.out.println("服务器运行中，等待客户端响应:");
        client=server.accept();
        int a=100;
        ps=new PrintStream(client.getOutputStream());
        ps.println(a);
        ps.close();
        client.close();
        server.close();
    }
}
