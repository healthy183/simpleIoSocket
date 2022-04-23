package com.kang.io.partCThreadAccept;

import com.kang.io.partZero.util.Constants;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/31.
 * @Author Administrator
 * @Version
 */
public class PartCAcceptClient {

    public static void main(String[] args) {
        try {
            Socket  socket = new Socket("127.0.0.1", Constants.PORT);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("TEST MSG");
            dos.flush();
            new PartCAcceptThread(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
