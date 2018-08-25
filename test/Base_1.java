package test;


import java.lang.reflect.InvocationTargetException;

public class Base_1
{
    private String baseName = "base";
    public Base_1()
    {
        System.out.println(baseName);
    }
    public void call(){
        System.out.println("hello");
    }
    public void callName() throws ClassNotFoundException {
        Class base = Base_1.class;
        Class test = Class.forName("test.Base_1");
        try {
            Base_1 b = (Base_1) base.getConstructor().newInstance();
            b.call();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    static class Sub extends Base_1
    {
        private String baseName = "sub";
        public void callName()
        {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Base_1 b = new Base_1();
        b.callName();
    }
}
