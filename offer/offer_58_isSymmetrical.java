package offer;
/*
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class offer_58_isSymmetrical {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public boolean isSymmetrical(TreeNode pRoot){
        if(pRoot==null){
            return true;
        }
        return isTrue(pRoot.left, pRoot.right);
    }
    public boolean isTrue(TreeNode pLeft, TreeNode pRight){
        if(pLeft==null && pRight==null){
            return true;
        }
        if(pLeft==null || pRight==null){
            return false;
        }
        return (pLeft.val==pRight.val) //判断左右节点值是否相等
                && isTrue(pLeft.left, pRight.right)
                && isTrue(pLeft.right, pRight.left);
    }
    public static void main(String[] args) {
        offer_58_isSymmetrical test = new offer_58_isSymmetrical();
        TreeNode t = test.new TreeNode(1);
        /*
                        1
                   2         2
                4     5   5     4
                     3   8
         */
        //左
        t.left = test.new TreeNode(2);
        t.left.left = test.new TreeNode(4);
        t.left.right = test.new TreeNode(5);
        //右
        t.right = test.new TreeNode(2);
        t.right.left = test.new TreeNode(5);
        t.right.right = test.new TreeNode(4);
        System.out.println(test.isSymmetrical(t));
    }
}
