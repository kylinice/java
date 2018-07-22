package offer;

public class offer_15 {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    private ListNode first = null;
    public void insertFirst(int val){
        ListNode data = new ListNode(val);
        data.next = first;
        first = data;
    }
    public void display(){
        if(first == null){
            System.out.println("empty");
        }
        ListNode cur = first;
        while(cur!=null){
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fir = null;
        while(head!=null){
            ListNode data = new ListNode(head.val);
            data.next = fir;
            fir = data;
            head = head.next;
        }
        return fir;
    }


    public static void main(String[] args) {
        offer_15 test = new offer_15();
        test.insertFirst(4);
        test.insertFirst(3);
        test.insertFirst(2);
        test.insertFirst(1);
        test.display();
        System.out.println();
        test.ReverseList(test.first);
    }
}
