package test;
interface Car {
    void run();
}
class Audi implements Car{
    @Override
    public void run() {
        System.out.println("Audi");
    }
}
class Baoma implements Car{
    @Override
    public void run(){
        System.out.println("Baoma");
    }
}
class factory {
    public static Car createCar(String str){
        Car c = null;
        if(str.equals("Audi")){
            c = new Audi();
        }
        if(str.equals("Baoma")){
            c = new Baoma();
        }
        return c;
    }
}
public class test_factory{
    public static void main(String[] args) {
        Car audi = factory.createCar("Audi");
        Car baoma = factory.createCar("Baoma");
        audi.run();
        baoma.run();
    }
}
