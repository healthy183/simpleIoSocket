package com.kang.io.partDThreadPool;

import com.kang.io.common.CommonNet;
import com.kang.io.partCThread.ServerReadThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/6.
 * @Author Administrator
 * @Version
 */
public class DServer {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2, // 8
            10,
            120L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(10));

    public static void main(String[] args) {
        System.out.println("simple server start");
        try {
            ServerSocket serverSocket = new ServerSocket(CommonNet.port);
            while (true){
                Socket socket = serverSocket.accept();
                executor.execute(new ServerReadThread(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
