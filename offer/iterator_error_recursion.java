package offer;

import java.util.ArrayList;
import java.util.Iterator;

public class iterator_error_recursion {
    public static void printList(Iterator itr, int i){

        if(!itr.hasNext()){
            return;
        }
        System.out.println(itr.next());
        i++;
        printList(itr, i);
        System.out.println("fff" + i);
    }
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            list.add("a" + i);
        }

        Iterator it = list.iterator();
        System.out.println(it);
        printList(it, 0);
    }
}
