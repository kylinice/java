package test;

class Animal{
    private String name = "test";
    public Animal(){

    }
    private void test() {

    }
    public Animal(int n){

    }
    private void fun(int n){

    }
    final void test1(){

    }
    final void test1(int n){

    }
}
class Dog extends Animal{
    public void fun(int n){

    }
}
class Cat extends Animal{

}
class AS{
    public AS foo(){return this;}
}
class B extends AS{
    public AS foo(){
        return this;
    }
}
class C extends B{
    public C foo(){
        return new C();
    }
}
public class test_classcastException {

    public static int beforeFinally(){
        int a = 0;
        try{
            a = 1;
            return a;
        }finally{
            a = 2;
            //return a;
        }
    }
    public static void main(String[] args) {
        //String foo1 = args[0];
        //String foo2 = args[1];
        //String foo3 = args[2];
        Animal a3 = new Animal();
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        //((Dog) a1).fun(1);
        System.out.println(beforeFinally());
    }
}
