package TCPconnect;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.SocketHandler;

/**
 * User: 兴希
 * Date: 2020/7/25
 * Time: 22:18
 * Description: No Description
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        Socket accept = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        String line = "";
        while ((line=br.readLine())!=null){

            System.out.println("客户端输入信息："+line);
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        ss.close();
        System.out.println("服务器关闭");
    }
}
