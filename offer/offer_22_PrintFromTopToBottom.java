package offer;
/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class offer_22_PrintFromTopToBottom {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + ",");
        }
        return list;
    }
    public static void main(String[] args) {
        offer_22_PrintFromTopToBottom test = new offer_22_PrintFromTopToBottom();
        offer_22_PrintFromTopToBottom.TreeNode t = test.new TreeNode(1);
        //左
        t.left = test.new TreeNode(2);
        t.left.left = test.new TreeNode(4);
        t.left.right = test.new TreeNode(5);
        t.left.right.left = test.new TreeNode(9);
        //右
        t.right = test.new TreeNode(3);
        t.right.left = test.new TreeNode(6);
        t.right.right = test.new TreeNode(7);
        t.right.left.left = test.new TreeNode(8);
        test.PrintFromTopToBottom(t);
    }
}
