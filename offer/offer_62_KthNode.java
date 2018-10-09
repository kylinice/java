package offer;

import java.util.Stack;

/*
给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class offer_62_KthNode {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
    TreeNode ans = null;
    int count = 0;
    int count1 = 0;
    int count2 = 0;
    public TreeNode KthNode(TreeNode root, int k){
        if(root==null){
            return null;
        }
        KthNode(root.left, k);
        if(++count==k){
            ans = root;
        }
        KthNode(root.right, k);
        return ans;
    }
    public TreeNode KthNode_recursion(TreeNode root, int k){
        if(root==null){
            return null;
        }
        TreeNode ret = KthNode_recursion(root.left, k);
        if(ret!=null){
            return ret;
        }
        if(++count1==k){
            //System.out.println(root.val);
            return root;
        }
        ret = KthNode_recursion(root.right, k);
        if(ret!=null){
            return ret;
        }
        return null;
    }
    public TreeNode KthNode_stack(TreeNode root, int k){
        if(root==null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp;
        //用current替代root，看起来方便
        TreeNode current = root;
        while(!stack.empty() || current!=null){
            //先走完左孩子
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            //结点没有左孩子了，出栈，访问结点
            if(!stack.empty()){
                temp = stack.pop();
                if(++count2==k){
                    return temp;
                }
                //System.out.print(temp.val + ",");
                //current指向右节点
                current = temp.right;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        /*
    	    5
    	   /  \
    	  3    7
    	 / \  / \
    	2  4  6  8
         */
        offer_62_KthNode test = new offer_62_KthNode();
        TreeNode t = test.new TreeNode(5);
        t.left = test.new TreeNode(3);
        t.right = test.new TreeNode(7);
        t.left.left = test.new TreeNode(2);
        t.left.right = test.new TreeNode(4);
        t.right.left = test.new TreeNode(6);
        t.right.left = test.new TreeNode(8);
        TreeNode t1 = test.KthNode(t, 3);
        TreeNode t2 = test.KthNode_recursion(t, 3);
        TreeNode t3 = test.KthNode_stack(t, 3);
        System.out.println(t1.val);
        System.out.println(t2.val);
        System.out.println(t3.val);

    }
}
