package offer;

public class offer_14 {
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
        ListNode fir = null;
        if(head==null){
            System.out.println("empty");
        }
        int i=1;
        while(head!=null){
            ListNode data = new ListNode(head.val);
            data.next = fir;
            fir = data;
            head = head.next;
        }
        ListNode result = null;
        while(fir!=null){
            if(i<=k){
                ListNode text = new ListNode(fir.val);
                text.next = result;
                result = text;
                fir = fir.next;
                i++;
            }else{
                break;
            }
        }
        if(fir==null&&i<=k){
            return null;
        }else{
            return result;
        }


    }


    public static void main(String[] args) {
        offer_14 test = new offer_14();
        test.insertFirst(4);
        test.insertFirst(3);
        test.insertFirst(2);
        test.insertFirst(1);
        test.display();
        System.out.println();
        test.FindKthToTail(test.first,6);
    }
}
