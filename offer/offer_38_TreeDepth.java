package offer;

import java.util.TreeSet;

public class offer_38_TreeDepth {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public int TreeDepth(TreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }
        int left = TreeDepth(pRoot.left);
        int right = TreeDepth(pRoot.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        offer_38_TreeDepth test = new offer_38_TreeDepth();
        offer_38_TreeDepth.TreeNode t = test.new TreeNode(1);
        /*
                        1
                   2         3
                4     5   6     7
                     3   8
        */
        //左
        t.left = test.new TreeNode(2);
        t.left.left = test.new TreeNode(4);
        t.left.right = test.new TreeNode(5);
        t.left.right.left = test.new TreeNode(3);
        //右
        t.right = test.new TreeNode(3);
        t.right.left = test.new TreeNode(6);
        t.right.right = test.new TreeNode(7);
        t.right.left.left = test.new TreeNode(8);
        System.out.println(test.TreeDepth(t));
    }

}
