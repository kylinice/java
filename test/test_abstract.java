package test;

interface A {
    void a();
    void b();
    void c();
    void d();
    void e();
    default void f(){

    }
}
abstract class test_adapter implements A{
    public test_adapter(String str){
        System.out.println("create test_adapter");
    }
    @Override
    public void a() {
        System.out.println("super a");
    }

    @Override
    public void b() {

    }

    @Override
    public void c() {

    }

    @Override
    public void d() {

    }

    @Override
    public void e() {

    }

    @Override
    public void f() {

    }

    public void g(){
        System.out.println("g");
    }
    public static void main(String[] args) {

    }
}
public class test_abstract extends test_adapter{
    public test_abstract(String str) {
        super(str); //必须加super，因为父类没有无参数构造函数
    }

    @Override
    public void a() {
        System.out.println("son a");
    }

    public void g(){
        //super.g();
        System.out.println("test_abstract g");
    }
    public static void main(String[] args) {
        test_adapter test = new test_abstract("");
        test.a();
        test.g();
    }
}
