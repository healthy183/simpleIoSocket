package com.kang.io.partA;

import com.kang.io.common.CommonNet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/6.
 * @Author Administrator
 * @Version
 */
public class AClient {

    public static void main(String[] args) {
        System.out.println("simple client");
        try {
            Socket socket = new Socket(CommonNet.IP,CommonNet.port);
            OutputStream outputStream = socket.getOutputStream();
            PrintStream ps = new PrintStream(outputStream);
            ps.println("i am tom");
            ps.flush();
            ps.close();//发送完毕请关闭输出流，否则server会报错SocketException: Connection reset
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
