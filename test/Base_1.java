package test;

public class Base_1
{
    private String baseName = "base";
    public Base_1()
    {
        callName();
    }

    public void callName()
    {
        System. out. println(baseName);
    }

    static class Sub extends Base_1
    {
        private String baseName = "sub";
        public void callName()
        {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args)
    {
        Base_1 b = new Sub();
    }
}
