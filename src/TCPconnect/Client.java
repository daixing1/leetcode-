package TCPconnect;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * User: 兴希
 * Date: 2020/7/25
 * Time: 22:28
 * Description: No Description
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",1234);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader sbr = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line = "";
        String msg = "";
        while ((line=br.readLine())!=null){
            if ("88".equals(line)){
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
            if ((msg = sbr.readLine())!=null){
                System.out.println("服务端消息"+msg);
            }
        }
        socket.close();
        System.out.println("客户端关闭");
    }
}
