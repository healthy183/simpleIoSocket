package com.kang.io.partFchat;

import java.io.*;
import java.net.Socket;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/22.
 * @Author Administrator
 * @Version
 */
@Deprecated
public class FSecondThreadAccept extends Thread{

    private Socket newSocket;
    private Socket oldSocket;

    public FSecondThreadAccept(Socket newSocket, Socket oldSocket){
        this.newSocket = newSocket;
        this.oldSocket = oldSocket;
    }

    @Override
    public void run() {
        InputStream is = null;
        try {
            is = newSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("FSecondThread server readMsg:"+line);
            }
            DataOutputStream dos = new DataOutputStream(oldSocket.getOutputStream());
            dos.writeUTF("accept:"+line);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
