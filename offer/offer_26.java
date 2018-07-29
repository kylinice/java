package offer;

public class offer_26 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    TreeNode head;
    TreeNode current;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        Convert(pRootOfTree.left);
        //找到最左叶子节点，作为根节点。head标记根节点
        if(head==null){
            head = pRootOfTree;
            current = pRootOfTree;
        }
        else{
            current.right = pRootOfTree;
            pRootOfTree.left = current; //不影响找到右节点
            current = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return head;
    }
    public static void main(String[] args) {
        offer_26 test = new offer_26();

    }
}
