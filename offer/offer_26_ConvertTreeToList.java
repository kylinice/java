package offer;
/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class offer_26_ConvertTreeToList {
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
        offer_26_ConvertTreeToList test = new offer_26_ConvertTreeToList();

    }
}
