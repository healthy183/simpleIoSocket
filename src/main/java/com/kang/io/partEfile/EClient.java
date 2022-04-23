package com.kang.io.partEfile;

import com.kang.io.common.CommonNet;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/17.
 * @Author Administrator
 * @Version
 */
public class EClient {

    public static void main(String[] args) {
        InputStream is = null;
        DataOutputStream dos = null;
        try {
            is = new FileInputStream("D:\\bin\\a.txt");
            Socket socket = new Socket(CommonNet.IP,CommonNet.port);
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(".txt");//设置后缀
            byte[] buffer = new byte[1024];
            int len;
            while((len =(is.read(buffer))) > 0){
                dos.write(buffer,0,len);
            }
            dos.flush();
            dos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(dos != null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
