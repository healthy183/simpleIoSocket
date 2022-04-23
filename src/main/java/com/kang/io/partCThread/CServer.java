package com.kang.io.partCThread;

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
public class CServer {

    public static void main(String[] args) {
        System.out.println("simple server start");
        try {
            ServerSocket serverSocket = new ServerSocket(CommonNet.port);
            while (true){
                Socket socket = serverSocket.accept();
                new ServerReadThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
