package com.kang.io.partCThread;

import com.kang.io.common.CommonNet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/6.
 * @Author Administrator
 * @Version
 */
public class CClient {

    public static void main(String[] args) {
        System.out.println("simple client");
        try {
            Socket socket = new Socket(CommonNet.IP,CommonNet.port);
            OutputStream os  = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.print("say sth pls:");
                String msg = sc.nextLine();
                if("exit".equalsIgnoreCase(msg)){
                    ps.println("i need to leave,bye");
                    ps.flush();
                    ps.close();
                    break;
                }else{
                    ps.println(msg);
                    ps.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
