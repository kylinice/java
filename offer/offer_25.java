package offer;

public class offer_25 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        //复制第一步，在每个节点N后面复制一个节点N'
        RandomListNode pNode = pHead;
        while(pNode!=null){
            RandomListNode pCloned = new RandomListNode(pNode.label);
            pCloned.next = pNode.next;
            pNode.next = pCloned;
            pNode = pCloned.next;
        }
        //复制第二步，在每个N'的random指向对应的节点
        pNode = pHead;
        while(pNode!=null){
            RandomListNode pCloned = pNode.next;
            if(pNode.random!=null){
                pCloned.random = pNode.random.next;
            }
            pNode = pCloned.next;
        }
        //复制第三步，拆分链表。奇数位置的节点连起来为原始链表，偶数位置的节点连起来则为复制后的链表
        pNode = pHead;
        RandomListNode head;
        RandomListNode root;
        //head和root都指向第一个N',head标记复制链表的头结点。root用来迭代
        root = pNode.next;
        head = root;
        //pNode指向下一个N或者null
        pNode.next = root.next;
        pNode = pNode.next;

        while(pNode!=null){
            root.next = pNode.next;
            root = root.next;
            pNode.next = root.next;
            pNode = pNode.next;
        }
        return head;
    }


    public static void main(String[] args) {
        offer_25 test = new offer_25();
        RandomListNode head = test.new RandomListNode(1);
        RandomListNode root = head;
        RandomListNode Phead = head;
        head.next = test.new RandomListNode(2);
        head.next.next = test.new RandomListNode(3);
        head.next.next.next = test.new RandomListNode(4);
        head.next.next.next.next = test.new RandomListNode(5);

        Phead.random = head.next.next;
        Phead.next.random = head.next.next.next.next;
        Phead.next.next.next.random = head.next;
        while(root!=null){
            System.out.println(root.label);
            root = root.next;
        }
        System.out.println(head.random.label);
        System.out.println(head.next.random.label);
        System.out.println(head.next.next.next.random.label);
        test.Clone(head);
    }
}
