package test;

import java.io.*;

public class test_fileIO {
    public static void main(String[] args) {
        File file = new File("file.txt");
        //FileOutputStream
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream output = new FileOutputStream(file);
            String str = "Java数据交流管道——IO流";
            byte[] bytes = str.getBytes();
            output.write(bytes);
            output.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        //FileInputStream
        try{

            FileInputStream input = new FileInputStream(file);
            //定义一个字节缓冲区,该缓冲区的大小根据需要来定义
            byte[] bytes2 = new byte[1024];
            int len = input.read(bytes2);
            System.out.println("文件中的信息是：" + new String(bytes2, 0, len));

            input.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        //FileReader
        try {
            FileWriter writer = new FileWriter(file);
            // 向文件写入内容
            writer.write("This is an example\r\n");
            writer.write("aello"+" world!");
            writer.write("hahaha");
            writer.flush();
            writer.close();
            // 创建 FileReader 对象
            FileReader fr = new FileReader(file);
            char[] a = new char[100];
            fr.read(a); // 读取数组中的内容
            for (char c : a)
                System.out.print(c); // 一个一个打印字符
            System.out.println();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //BufferedOutputStream
        BufferedOutputStream Buff = null;
        try{
            Buff = new BufferedOutputStream(new FileOutputStream(file));
            long begin0 = System.currentTimeMillis();
            Buff.write("测试java 文件操作\r\n".getBytes());
            Buff.flush();
            Buff.close();
            long end0 = System.currentTimeMillis();
            System.out.println("BufferedOutputStream执行耗时:" + (end0 - begin0) + " 毫秒");
        }catch (IOException e){
            e.printStackTrace();
        }
        //BufferInputStream
        try {
            FileInputStream fis=new FileInputStream(file);
            BufferedInputStream bis=new BufferedInputStream(fis);
            //自己定义一个缓冲区
            byte[] buffer=new byte[100];
            int flag=0;
            while((flag=bis.read(buffer))!=-1){
                System.out.print(new String(buffer, 0, flag)+",");
            }
            //关闭的时候只需要关闭最外层的流就行了
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }





    }
}
