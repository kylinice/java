package test;

class Base1
{
    public void method()
    {
        System.out.println("Base");
    }
}
class Son extends Base1
{
    public void method()
    {
        System.out.println("Son");
    }

    public void methodB()
    {
        System.out.println("SonB");
    }
}
public class Test01
{
    public static void sss(){
        System.out.println("yes");
    }
    public static void main(String[] args)
    {   Test01 test = new Test01();
        test.sss();
        Base1 base = new Son();
        base.method();
        Son son=(Son)base;
        son.methodB();
    }
}
