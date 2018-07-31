package offer;
import java.util.Stack;

public class offer_20_minStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int node) {
        stack1.push(node);
        if(stack2.empty()){
            stack2.push(node);
        }
        else{
            if(stack2.peek().intValue()>=stack1.peek().intValue()){
                stack2.push(node);
            }
        }
    }

    public void pop() {
        if(!stack1.empty()&&!stack2.empty()){
            if(stack1.peek().equals(stack2.peek())){
                stack2.pop();
            }
            stack1.pop();
        }
    }

    public int top() {
        if(!stack1.empty()){
            return stack1.peek();
        }else return Integer.MIN_VALUE;

    }

    public int min() {
        if(!stack2.empty()){
            return stack2.peek();
        }else return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        offer_20_minStack test = new offer_20_minStack();
        test.push(2);
        test.push(3);
        test.push(2);

        System.out.println(test.top());
        System.out.println(test.min());
        test.pop(); //2,3
        System.out.println(test.top());
        System.out.println(test.min());
        test.push(1); // 2,3,1
        System.out.println(test.top());
        System.out.println(test.min());
        test.push(5); // 2,3,1,5
        System.out.println(test.top());
        System.out.println(test.min());
        test.pop();// 2,3,1
        System.out.println(test.top());
        System.out.println(test.min());
        test.pop();// 2,3
        test.pop();//2
        test.pop();
        System.out.println(test.top());
        System.out.println(test.min());
        //System.out.println(test.stack2.peek());
        //System.out.println(test.stack1.peek().equals(test.stack1.peek()));

    }

}
