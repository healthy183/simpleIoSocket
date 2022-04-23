package com.kang.run;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2022/3/23.
 * @Author Administrator
 * @Version
 */
public class SimpleRun {

    public static void main(String[] args) {
        try(OutputStream os =
                    new FileOutputStream("D:\\bin\\"+
                            UUID.randomUUID() + ".txt")){
            os.write("kkkk".getBytes(StandardCharsets.UTF_8));
            os.flush();
            os.close();
            System.out.println("保存完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
