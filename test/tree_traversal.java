package test;

public class tree_traversal {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
    //前序遍历
    public void preorder_traversal(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val + ",");
        preorder_traversal(root.left);
        preorder_traversal(root.right);
    }
    //中序遍历
    public void inorder_traversal(TreeNode root){
        if(root==null){
            return;
        }
        inorder_traversal(root.left);
        System.out.print(root.val + ",");
        inorder_traversal(root.right);
    }
    //后序遍历
    public void postorder_traversal(TreeNode root){
        if(root==null){
            return;
        }
        postorder_traversal(root.left);
        postorder_traversal(root.right);
        System.out.print(root.val + ",");
    }


    public static void main(String[] args) {
        tree_traversal test = new tree_traversal();
        tree_traversal.TreeNode t = test.new TreeNode(1);
        t.left = test.new TreeNode(2);
        t.right = test.new TreeNode(3);
        t.left.left = test.new TreeNode(4);
        t.left.right = test.new TreeNode(5);
        t.right.left = test.new TreeNode(6);
        t.right.right = test.new TreeNode(7);
        test.preorder_traversal(t);
        System.out.println();
        test.inorder_traversal(t);
        System.out.println();
        test.postorder_traversal(t);
        System.out.println();
    }
}
