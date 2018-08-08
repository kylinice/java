package offer;
/*
操作给定的二叉树，将其变换为源二叉树的镜像。

二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
*/

public class offer_18_Mirror {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public void Mirror(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left!=null){
            Mirror(root.left);
        }
        if(root.right!=null){
            Mirror(root.right);
        }
    }
    //不加if
    public void Mirrors(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
    //other
    public void Mirror_3(TreeNode root){
        TreeNode temp = null;
        if(root!=null){
            temp =root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left!=null){
                Mirror(root.left);
            }
            if(root.right!=null){
                Mirror(root.right);
            }
        }
    }

    public static void main(String[] args) {
        offer_18_Mirror test = new offer_18_Mirror();
        offer_18_Mirror.TreeNode t = test.new TreeNode(1);
        t.left = test.new TreeNode(2);
        t.right = test.new TreeNode(3);
        t.left.left = test.new TreeNode(4);
        test.Mirror(t);
        System.out.println(t.right.right.val);

    }
}
