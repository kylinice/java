package test;

import java.io.*;

public class test_serializable implements Serializable{
    private int width;
    //不被序列化的属性
    private transient int height;
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }

    public static void main(String[] args) {
        test_serializable test = new test_serializable();
        test.setHeight(70);
        test.setWidth(100);
        //序列化
        try {
            //1.创建FileOutputStream
            FileOutputStream fs = new FileOutputStream("test_serializable.ser");
            //2.创建ObjectOutputStream
            ObjectOutputStream os = new ObjectOutputStream(fs);
            //3.writeObject
            os.writeObject(test);
            //4.关闭
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //反序列化
        try{
            //创建输入流
            FileInputStream fi = new FileInputStream("test_serializable.ser");
            ObjectInputStream oin = new ObjectInputStream(fi);
            //读出的Object对象转换成需要的对象
            test_serializable read_test = (test_serializable) oin.readObject();
            //输出transient变量
            System.out.println(read_test.getHeight());
            //输出非transient变量
            System.out.println(read_test.getWidth());
            //关闭
            oin.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
