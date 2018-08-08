package offer;
/*
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
import java.util.ArrayList;

public class offer_3_recursion {
    public class test_linklist {
        private class Data{
            private Object obj;
            private Data next = null;

            Data(Object obj){
                this.obj = obj;
            }

        }

        private Data first = null;

        private void insertFirst(Object obj){
            Data data = new Data(obj);
            data.next = first;
            first = data;
        }

        public void display(){
            if(first == null)
                System.out.println("empty");
            Data cur = first;
            while(cur != null)
            {
                System.out.print(cur.obj.toString() + " -> ");
                cur = cur.next;
            }
            System.out.println("\n");
        }
    }
    public static ArrayList<String> re = new ArrayList<>();
    public static ArrayList<String> printListFromTailToHead(offer_3_recursion.test_linklist.Data listNode) {
        if(listNode == null){
            return re;
        }

        printListFromTailToHead(listNode.next);
        re.add(listNode.obj.toString());
        return re;
    }


    public static void main(String[] args) {
        test_linklist li = new offer_3_recursion().new test_linklist();
        li.insertFirst(4);
        li.insertFirst(3);
        li.insertFirst(2);
        li.insertFirst(1);
        li.display();
        ArrayList<String> ss;
        //System.out.println(li.first.next.obj.toString());
        ss = printListFromTailToHead(li.first);
        System.out.println(ss.toString());

    }
}
