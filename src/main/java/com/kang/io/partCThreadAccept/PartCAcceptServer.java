package com.kang.io.partCThreadAccept;

import com.kang.io.partZero.util.Constants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/31.
 * @Author Administrator
 * @Version
 */
public class PartCAcceptServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(Constants.PORT);
            Socket socket = serverSocket.accept();
            try(DataInputStream dis = new DataInputStream(socket.getInputStream())){
                while (true){
                    String msg = dis.readUTF();
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF("accept:"+msg);
                    dos.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
