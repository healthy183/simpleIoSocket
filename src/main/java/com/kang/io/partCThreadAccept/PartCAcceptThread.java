package com.kang.io.partCThreadAccept;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/31.
 * @Author Administrator
 * @Version
 */
public class PartCAcceptThread extends Thread {

    private Socket socket;

    public PartCAcceptThread( Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            DataInputStream dis = new DataInputStream(socket.getInputStream());
           while(true){
               String nameDatas = dis.readUTF();
               System.out.println(nameDatas);
               try(OutputStream os =
                           new FileOutputStream("D:\\bin\\"+
                                   UUID.randomUUID() + ".txt")){
                   os.write(nameDatas.getBytes(StandardCharsets.UTF_8));
                   os.flush();
                   os.close();
                   System.out.println("保存完成");
               }
           }
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
