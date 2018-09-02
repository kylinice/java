package test;
import java.util.HashMap;
//懒汉式
class LazySingleton{
    private static LazySingleton instance = null;
    private LazySingleton(){

    }
    public static LazySingleton getInstance(){
        if(instance==null){
            instance = new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        LazySingleton test1 = getInstance();
        LazySingleton test2 = getInstance();
        System.out.println(test1==test2);
    }
}
//饿汉式
class EagerSingleton{
    private static EagerSingleton instance = new EagerSingleton();
    private EagerSingleton(){

    }
    public static EagerSingleton getInstance(){
        return instance;
    }
    public static void main(String[] args) {
        EagerSingleton test1 = getInstance();
        EagerSingleton test2 = getInstance();
        System.out.println(test1==test2);
    }
}

