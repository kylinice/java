package offer;

import java.util.List;
import java.util.HashMap;

/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class offer_56_deleteDuplication {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null || pHead.next==null){
            return pHead;
        }
        //设置头结点
        ListNode temp = new ListNode(-1);
        temp.next = pHead;
        //记录节点
        ListNode pre = temp;
        ListNode curNode = pHead;
        while(curNode!=null && curNode.next!=null){
            ListNode curNext = curNode.next;
            if(curNode.val == curNext.val){
                //把所有后面重复的节点都找出来
                while(curNext!=null && curNext.val==curNode.val){
                    curNext = curNext.next;
                }
                pre.next = curNext;
                curNode = curNext;
            }else{
                pre = curNode;
                curNode = curNode.next;
            }
        }
        return temp.next;
    }

    public static void main(String[] args) {
        offer_56_deleteDuplication test = new offer_56_deleteDuplication();
        offer_56_deleteDuplication.ListNode node = test.new ListNode(1);
        node.next = test.new ListNode(2);
        node.next.next = test.new ListNode(2);
        test.deleteDuplication(node);
    }
}
