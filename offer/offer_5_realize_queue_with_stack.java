package offer;
/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
import java.util.Stack;

public class offer_5_realize_queue_with_stack {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    public static void push(int node) {
        stack1.push(node);
    }

    public static int pop() {
        while (!stack1.empty()){
            int top = stack1.pop();
            stack2.push(top);
        }
        int first = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return first;
    }

    public static void main(String[] args) {

        int array[] = {1,2,3,4,5};
        for(int i=0; i<array.length;i++){
            push(array[i]);
        }
        push(7);
        System.out.println(pop());
        System.out.println(pop());



    }
}
