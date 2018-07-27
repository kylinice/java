package offer;

import javafx.scene.control.RadioButton;

public class offer_25 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
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

    }
}
