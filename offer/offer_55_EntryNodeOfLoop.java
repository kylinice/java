package offer;
/*
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class offer_55_EntryNodeOfLoop {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode MeetingNode(ListNode pHead){
        if(pHead==null){
            return null;
        }
        ListNode pSlow = pHead;
        if(pSlow.next==null){
            return null;
        }
        ListNode pFast = pSlow.next;
        while(pFast!=null){
            if(pFast==pSlow){
                return pFast;
            }else{
                pSlow = pSlow.next;
                pFast = pFast.next;
                if(pFast!=null){
                    pFast = pFast.next;
                }
            }
        }
        return null;
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meet = MeetingNode(pHead);
        if(meet==null){
            return null;
        }
        //计算环的个数
        int num = 1;
        ListNode m = meet;
        while(m.next!=meet){
            m = m.next;
            num++;
        }
        System.out.println(num);
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        //p2先走num步
        for(int i=0;i<num;i++){
            p2 = p2.next;
        }
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println(p1.val);
        return p1;
    }

    public static void main(String[] args) {
        offer_55_EntryNodeOfLoop test = new offer_55_EntryNodeOfLoop();
        offer_55_EntryNodeOfLoop.ListNode node = test.new ListNode(1);
        node.next = test.new ListNode(2);
        node.next.next = node;
        test.EntryNodeOfLoop(node);
    }
}
