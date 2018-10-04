package DataStructure;

import java.util.Stack;

public class tree_traversal {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
    //前序遍历 递归
    public void preorder_traversal(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val + ",");
        preorder_traversal(root.left);
        preorder_traversal(root.right);
    }
    //前序遍历 非递归
    public void preorder_stack(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        //先加入根节点
        stack.push(root);
        TreeNode temp;
        while(!stack.empty()){
            temp = stack.pop();
            //先输出根节点，然后右节点入栈，再左节点入栈
            if(temp!=null){
                System.out.print(temp.val + ",");
                stack.push(temp.right);
                stack.push(temp.left);
            }
        }

    }
    //中序遍历 递归
    public void inorder_traversal(TreeNode root){
        if(root==null){
            return;
        }
        inorder_traversal(root.left);
        System.out.print(root.val + ",");
        inorder_traversal(root.right);
    }
    //中序遍历 非递归
    public void inorder_stack(TreeNode root){
        if(root==null){
            return;
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
                System.out.print(temp.val + ",");
                //current指向右节点
                current = temp.right;
            }
        }

    }
    //后序遍历 递归
    public void postorder_traversal(TreeNode root){
        if(root==null){
            return;
        }
        postorder_traversal(root.left);
        postorder_traversal(root.right);
        System.out.print(root.val + ",");
    }
    //后序遍历 非递归
    public void postorder_stack(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev=null;
        //current替代root，看起来方便
        TreeNode current = root;
        while(current!=null || !stack.empty()){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            TreeNode top = stack.peek();
            //判断有没有右孩子，或者pop以后的栈顶的右节点为之前出栈的节点（比如9这个节点，之前出栈的节点为11，为9的右节点）
            if(top.right==null || top.right==prev){
                System.out.print(top.val + ",");
                //记录将要出栈的节点，后续判断
                prev = top;
                stack.pop();
            }else{
                current = top.right;
            }
        }
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
        tree_traversal test = new tree_traversal();
        tree_traversal.TreeNode t = test.new TreeNode(1);
        t.left = test.new TreeNode(2);
        t.right = test.new TreeNode(3);
        t.left.left = test.new TreeNode(4);
        t.left.left.right = test.new TreeNode(9);
        t.left.left.right.left = test.new TreeNode(10);
        t.left.right = test.new TreeNode(5);
        t.right.left = test.new TreeNode(6);
        t.right.right = test.new TreeNode(7);
        System.out.println("前序遍历 递归");
        test.preorder_traversal(t);
        System.out.println();

        System.out.println("前序遍历 非递归");
        test.preorder_stack(t);
        System.out.println();

        System.out.println("中序遍历 递归");
        test.inorder_traversal(t);
        System.out.println();

        System.out.println("中序遍历 非递归");
        test.inorder_stack(t);
        System.out.println();

        System.out.println("后序遍历 递归");
        test.postorder_traversal(t);
        System.out.println();

        System.out.println("后序遍历 非递归");
        test.postorder_stack(t);
        System.out.println();

    }
}
