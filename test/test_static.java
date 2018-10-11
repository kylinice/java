package test;

public class test_static {
    public void method(){
        System.out.println("父类普通方法");
    }
    public static void staticMethod(){
        System.out.println("父类静态方法");
    }


}
class test_son extends test_static{
    public void method(){
        System.out.println("子类重写父类普通方法");
    }
    public static void staticMethod(){
        System.out.println("子类重写父类静态方法");
    }
    public static void main(String[] args) {
        test_static father = new test_static();
        father.method();
        father.staticMethod();
        test_static.staticMethod();
        test_static son = new test_son();
        son.method();
        son.staticMethod();
        test_static.staticMethod();
        test_son son1 = new test_son();
        staticMethod();
        son1.staticMethod();
        test_son.staticMethod();

    }
}