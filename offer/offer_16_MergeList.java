package offer;
/*
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class offer_16_MergeList {
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
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode first_temp = null;
        ListNode last_temp = null;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                ListNode data = new ListNode(list1.val);
                if(first_temp==null){
                    first_temp = last_temp = data;
                }else{
                    last_temp.next = data;
                    last_temp = data;
                }
                list1 = list1.next;
            }else {
                ListNode data = new ListNode(list2.val);
                if(first_temp==null){
                    first_temp = last_temp = data;
                }else{
                    last_temp.next = data;
                    last_temp = data;
                }
                list2 = list2.next;
            }
        }
        if(list1==null){
            last_temp.next = list2;
        }else{
            last_temp.next = list1;
        }
        ListNode p = first_temp;
        while(p!=null){
            System.out.println(p.val);
            p = p.next;
        }
        return first_temp;
    }

    public static void main(String[] args) {
        offer_16_MergeList test1 = new offer_16_MergeList();
        offer_16_MergeList test2 = new offer_16_MergeList();
        int a1[] = {12,11,8,6,5};
        int a2[] = {1,5};
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
