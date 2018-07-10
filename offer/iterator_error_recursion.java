package offer;

import java.util.ArrayList;
import java.util.Iterator;

public class iterator_error_recursion {
    public static void printList(Iterator itr){

        if(!itr.hasNext()){
            return;
        }
        System.out.println(itr.next());
        printList(itr);
    }
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 20000; i++) {
            list.add("a" + i);
        }

        Iterator it = list.iterator();
        System.out.println(it);
        printList(it);
    }
}
