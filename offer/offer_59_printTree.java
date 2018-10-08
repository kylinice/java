package offer;

import java.util.ArrayList;
import java.util.Stack;

/*
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class offer_59_printTree {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> arr_all = new ArrayList<>();
        if(pRoot==null){
            return arr_all;
        }
        //存放奇数节点
        Stack<TreeNode> stack_odd = new Stack<>();
        //存放偶数节点
        Stack<TreeNode> stack_even = new Stack<>();
        stack_odd.push(pRoot);
        //奇偶层判断
        int next = 2;
        ArrayList<Integer> arr = new ArrayList<>();
        while(!stack_odd.empty() || !stack_even.empty()) {
            if (next % 2 == 0) {
                //把所有奇数层出栈，入栈的顺序从左到右
                while (!stack_odd.empty()) {
                    TreeNode temp = stack_odd.pop();
                    arr.add(temp.val);
                    if (temp.left != null) {
                        stack_even.push(temp.left);
                    }
                    if (temp.right != null) {
                        stack_even.push(temp.right);
                    }
                }
                //加入arr_all
                arr_all.add(new ArrayList<>(arr));
                arr.clear();
                //层数加1
                next++;
            } else {
                //把所有偶数层出栈，入栈的顺序从右到左
                while (!stack_even.empty()) {
                    TreeNode temp = stack_even.pop();
                    arr.add(temp.val);
                    if (temp.right != null) {
                        stack_odd.push(temp.right);
                    }
                    if (temp.left != null) {
                        stack_odd.push(temp.left);
                    }
                }
                arr_all.add(new ArrayList<>(arr));
                arr.clear();
                next++;
            }
        }
        for (ArrayList<Integer> arrayList : arr_all) {
            for (Integer a : arrayList) {
                System.out.print(a + ",");
            }
            System.out.println();
        }
        return arr_all;
    }
    public static void main(String[] args) {
        /*
    	    1
    	   /  \
    	  2    3
    	 / \  / \
    	4  5  6  7
    	 \
    	  9
    	 / \
    	10  11

         */
        offer_59_printTree test = new offer_59_printTree();
        TreeNode t = test.new TreeNode(1);
        t.left = test.new TreeNode(2);
        t.right = test.new TreeNode(3);
        t.left.left = test.new TreeNode(4);
        t.left.left.right = test.new TreeNode(9);
        t.left.left.right.left = test.new TreeNode(10);
        t.left.left.right.right = test.new TreeNode(11);
        t.left.right = test.new TreeNode(5);
        t.right.left = test.new TreeNode(6);
        t.right.right = test.new TreeNode(7);
        test.Print(t);
    }
}
