package com.kang.io.partDThreadPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/15.
 * @Author Administrator
 * @Version
 */
public class ServerReadRunable implements  Runnable {
        private Socket socket;
        public ServerReadRunable(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
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
