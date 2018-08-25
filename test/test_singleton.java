package test;
//懒汉式
public class test_singleton {
    private static test_singleton instance = null;
    private test_singleton(){

    }
    public static test_singleton getInstance(){
        if(instance==null){
            instance = new test_singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        test_singleton test1 = getInstance();
        test_singleton test2 = getInstance();
        System.out.println(test1==test2);
    }
}
//饿汉式
class singleton{
    private static singleton instance = new singleton();
    private singleton(){

    }
    public static singleton getInstance(){
        return instance;
    }
    public static void main(String[] args) {
        singleton test1 = getInstance();
        singleton test2 = getInstance();
        System.out.println(test1==test2);
    }
}