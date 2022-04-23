package com.kang.io.partFchat;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/15.
 * @Author Administrator
 * @Version
 */
public class FFirstThreadAccept extends  Thread {

    private  Socket socket;

       public FFirstThreadAccept(Socket socket){
           this.socket = socket;
        }

        @Override
        public void run() {
            try{
                DataInputStream dis = new DataInputStream(socket.getInputStream());
            while (true){
                String nameDatas = dis.readUTF();
                System.out.println(nameDatas);
            }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
