package test;

import java.util.ArrayList;
import java.util.Iterator;

public class test_02 {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        for(int i=0;i<10;i++){
            l.add(String.valueOf(i));
        }
        l.stream().filter(e -> !e.equals("5")).forEach(System.out::print);
        System.out.println();
        ArrayList<String> l1 = new ArrayList<>();
        for(int i=0;i<10;i++){
            l1.add(String.valueOf(i));
        }
        /*会出现ConcurrentModificationException
        Iterator<String> ita = l1.iterator();
        while(ita.hasNext()){
            ita.next();
            l1.remove();//这里有错
        }
         */
        //不会出现ConcurrentModificationException
        Iterator<String> ita = l1.iterator();
        while(ita.hasNext()){
            ita.next();
            l1.remove(ita.next());
            ita.remove();
        }
        System.out.println(l1.size());
        ArrayList<Integer> l2 = new ArrayList<>();
        int s = Integer.MAX_VALUE-8;
        System.out.printf("%#x", s);
        for(int i=0;i<10;i++){
            l1.add(String.valueOf(i));
        }
        for(int i =0;i<l1.size();++i){
            int v = Integer.parseInt(l1.get(i));
            if(v%2==0){
                l1.remove(String.valueOf(v));
            }
        }
        l1.forEach(System.out::println);

    }

}
