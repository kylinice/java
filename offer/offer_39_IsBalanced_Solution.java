package offer;
/*
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class offer_39_IsBalanced_Solution {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        int depth[] = {0};
        return IsBalanced(root, depth);
    }
    public boolean IsBalanced(TreeNode root, int[] depth){
        if(root==null){
            depth[0] = 0;
            return true;
        }
        int left[] = {0};
        int right[] = {0};
        if((IsBalanced(root.left, left))
                && (IsBalanced(root.right, right))){
            int diff = left[0] - right[0];
            if(diff<=1 && diff>=-1){
                depth[0] = Math.max(left[0], right[0]) + 1;
                return true;
            }
        }
        return false;
    }
    public boolean Is_Solution(TreeNode root){
        return getDepth(root) != -1;
    }
    public int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        if(left==-1){
            return -1;
        }
        int right = getDepth(root.right);
        if(right==-1){
            return -1;
        }
        return Math.abs(left-right)>1?-1:1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        offer_39_IsBalanced_Solution test = new offer_39_IsBalanced_Solution();
        offer_39_IsBalanced_Solution.TreeNode t = test.new TreeNode(1);
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
        t.right.left.left.left = test.new TreeNode(9);
        System.out.println(test.IsBalanced_Solution(t));
    }
}
