package com.kang.io.partZero;

import java.io.File;

@Deprecated
public class RunDemo {
    public static void main(String[] args) {
        File f = new File("D:\\ioTest");
        File[] fs = f.listFiles();
        for (File file : fs) {
            Integer num = Integer.valueOf(file.getName().substring(0 , file.getName().indexOf("."))) + 23;
            file.renameTo(new File(f  , num +"."+ file.getName().substring(file.getName().indexOf("."))));
        }
    }
}
