package offer;

public class offer_14_me {
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
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }
        ListNode pre = head;
        ListNode last = head;
        for(int i=1;i<k;i++){
            if(pre.next!=null){
                pre = pre.next;
            }else{
                return null;
            }
        }
        while(pre.next!=null){
            pre = pre.next;
            last = last.next;
        }
        System.out.println(last.val);
        //System.out.println(last.next.next.val);
        return last;
    }


    public static void main(String[] args) {
        offer_14_me test = new offer_14_me();
        test.insertFirst(4);
        test.insertFirst(3);
        test.insertFirst(2);
        test.insertFirst(1);
        test.display();
        System.out.println();
        test.FindKthToTail(test.first,2);
    }
}
