package test;

class Two{
    byte x;
}
public class Pass0{
    public static void main(String[] args){
        Pass0 p=new Pass0();
        p.start();
    }
    void start(){
        Two t=new Two();
        System.out.print(t.x+"");
        Two t2=fix(t);
        System.out.print(t.x+" " +t2.x);
    }
    Two fix(Two tt){
        tt.x=42;
        return tt;
    }
}