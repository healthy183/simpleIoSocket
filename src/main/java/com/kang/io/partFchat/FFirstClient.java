package com.kang.io.partFchat;
import com.kang.io.common.CommonNet;
import java.io.*;
import java.net.Socket;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/6.
 * @Author Administrator
 * @Version
 */
public class FFirstClient {

    public static void main(String[] args) {
        System.out.println("FFirstClient client");
        try {
            Socket  socket = new Socket(CommonNet.IP,CommonNet.port);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("i am  FFirstClient");
            dos.flush();
            new FFirstAcceptSaveFile(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
