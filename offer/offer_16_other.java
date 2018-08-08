package offer;
/*
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class offer_16_other {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    ListNode first = null;
    ListNode last = null;
    public void insertFirst(int val){
        ListNode data = new ListNode(val);
        if(first==null){
            last = data;
        }
        data.next = first;
        first = data;
    }
    public void insertLast(int val){
        ListNode data = new ListNode(val);
        if(first==null){
            first = data;
        }else{
            last.next = data;
        }
        last = data;
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
    //无头结点
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode mergeHead = null;
        ListNode current = null;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                if(mergeHead==null){
                    mergeHead = current = list1;
                }else{
                    current.next = list1;
                    current = list1;// current = current.next
                }
                list1 = list1.next;
            }else {
                if(mergeHead==null){
                    mergeHead = current = list2;
                }else{
                    current.next = list2;
                    current = list2; //current = current.next
                }
                list2 = list2.next;
            }
        }
        if(list1==null){
            current.next = list2;
        }else{
            current.next = list1;
        }
        ListNode p = mergeHead;
        while(p!=null){
            System.out.println(p.val);
            p = p.next;
        }
        return mergeHead;

    }
    //有头结点
    public ListNode Merge_with_head(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode root = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                head = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                head = list2;
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            head.next = list2;
        } else {
            head.next = list1;
        }
        ListNode p = root.next;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
        return root.next;
    }
    //递归
    public ListNode Merge_recursion(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if(list1.val<=list2.val){
            list1.next = Merge_recursion(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge_recursion(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        offer_16_other test1 = new offer_16_other();
        offer_16_other test2 = new offer_16_other();
        int a1[] = {12,11,8,6,5};
        int a2[] = {2,4,5,8};
        //链表1
        for(int i=0;i<a1.length;i++){
            test1.insertFirst(a1[i]);
        }
        test1.display();
        System.out.println();
        //链表2
        for(int i=0;i<a2.length;i++){
            test2.insertLast(a2[i]);
        }
        test2.display();
        System.out.println();
        test1.Merge(test1.first, test2.first);

    }
}
