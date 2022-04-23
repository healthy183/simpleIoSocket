package com.kang.io.partFchat;

import com.kang.io.common.CommonNet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/6.
 * @Author Administrator
 * @Version
 */
public class FServer {

    private  Socket oldSocket;

    public static void main(String[] args) {
        System.out.println("simple server start");
        FServer  fServer = new FServer();
        fServer.runServer();
    }

    public void runServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(CommonNet.port);
            while (true){
                //先进先占坑
                Socket socket = serverSocket.accept();
                if(oldSocket == null){
                    oldSocket = socket;
                    new FFirstThreadAccept(oldSocket).start();
                }else{
                    Socket  newSocket = socket;
                    try{
                        try(InputStream is = newSocket.getInputStream()){
                            BufferedReader br = new BufferedReader(new InputStreamReader(is));
                            String line;
                            while ((line = br.readLine()) != null) {
                                System.out.println("FSecondThread server readMsg:"+line);
                                //这里不能try close，否则会导致FFirstAcceptSaveFile的readUTF()异常
                                DataOutputStream dos = new DataOutputStream(oldSocket.getOutputStream());
                                dos.writeUTF("accept:"+line);
                                dos.flush();
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
