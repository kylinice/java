package test;

public class thread_2 extends Thread{
    public static void main(String[] args) {
        thread_2 t = new thread_2();
        thread_2 s = new thread_2();
        t.start();
        System.out.println("one.");
        s.start();
        System.out.println("two.");

    }
    public void run(){
        System.out.println("Thread");
    }
}
