package offer;



/*
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class offer_57_GetNext {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode==null){
            return null;
        }
        //如果有右子树，则中序遍历的下一个节点为右子树的最左节点
        if(pNode.right!=null){
            pNode = pNode.right;
            while(pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }
        //如果不是根节点，且没有右子树，则找第一个当前节点是父节点左孩子的节点
        while(pNode.next!=null){
            TreeLinkNode pRoot = pNode.next;
            //如果pNode是pRoot的左孩子
            if(pRoot.left==pNode){
                return pRoot;
            }
            //找不到就继续往上找，直至根节点
            pNode = pNode.next;
        }
        //该节点是中序遍历的最后一个节点，返回null
        return null;
    }
    public static void main(String[] args) {
        offer_57_GetNext test = new offer_57_GetNext();
        TreeLinkNode t = test.new TreeLinkNode(1);
        /*
                        1
                   2         3
                4     5   6     7
                     3   8
        */
        System.out.println(test.GetNext(t));
    }
}
