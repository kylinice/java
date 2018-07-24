package test;
class Value{
    public int i = 15;
}
public class test_2 {
    public void first(){
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v,i);
        System.out.println(" " + v.i);
    }
    public void second(Value v, int i){
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.print(v.i + " " + i);
    }
    public static void main(String[] args) {
        test_2 t = new test_2();
        t.first();
    }
}
