package tcptestD_R;
import java.io.*;
import java.net.*;
public class tcp_client {
    public static void main(String[] args) throws Exception{
        Socket client=new Socket("localhost",8848);
        BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
        String s=br.readLine();
        System.out.println("content:"+s);
        br.close();
        client.close();
    }
}
