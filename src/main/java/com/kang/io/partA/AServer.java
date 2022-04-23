package com.kang.io.partA;
import com.kang.io.common.CommonNet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/6.
 * @Author Administrator
 * @Version
 */
public class AServer {

    public static void main(String[] args) {
        System.out.println("simple server start");
        try {
            ServerSocket serverSocket = new ServerSocket(CommonNet.port);
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            //字节流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("server readMsg:"+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
