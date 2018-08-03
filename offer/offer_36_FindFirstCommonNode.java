package offer;

public class offer_36_FindFirstCommonNode {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null){
            return null;
        }
        int p1_len = getlen(pHead1);
        int p2_len = getlen(pHead2);
        ListNode first = pHead1;
        ListNode second = pHead2;
        int diff = p1_len - p2_len;
        if(p1_len<p2_len){
            first = pHead2;
            second = pHead1;
            diff = p2_len - p1_len;
        }
        for(int i=0;i<diff;i++){
            first = first.next;
        }
        while(first!=null && second!=null && first!=second){
            first = first.next;
            second = second.next;
        }
        return first;
    }
    public int getlen(ListNode pHead){
        int len=0;
        ListNode p = pHead;
        while(p!=null){
            len++;
            p = p.next;
        }
        return len;
    }

    public static void main(String[] args) {
        offer_36_FindFirstCommonNode test = new offer_36_FindFirstCommonNode();
        // 1.3.4.5.8
        ListNode list1 = test.new ListNode(1);
        list1.next = test.new ListNode(3);
        list1.next.next = test.new ListNode(4);
        list1.next.next.next = test.new ListNode(5);
        list1.next.next.next.next = test.new ListNode(8);// sss
        // 2.5.8
        ListNode list2 = test.new ListNode(2);
        list2.next = list1.next.next.next;
        //list2.next = test.new ListNode(5);
        list2.next.next = test.new ListNode(7); // 备注sss的那行也被修改
        //list2.next.next = list1.next.next.next.next;
        ListNode common = test.FindFirstCommonNode(list1, list2);
        System.out.println(common.next.val);
    }
}
