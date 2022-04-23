package com.kang.io.partEfile;

import com.kang.io.common.CommonNet;
import com.kang.io.partCThread.ServerReadThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/17.
 * @Author Administrator
 * @Version
 */
public class EServer {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(CommonNet.port);
            while (true){
                Socket socket = serverSocket.accept();
                try(DataInputStream dis = new DataInputStream(socket.getInputStream())){
                    String suffix = dis.readUTF();
                   try(OutputStream os =
                               new FileOutputStream("D:\\bin\\"+
                                       UUID.randomUUID() + suffix)){
                       byte[] buffer = new byte[1024];
                       int len;
                       while((len = dis.read(buffer))> 0){
                           os.write(buffer,0, len);
                       }
                       System.out.println("保存完成");
                   }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
