package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class offer_60_Print {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> arr_all = new ArrayList<>();
        if(pRoot==null){
            return arr_all;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //将root节点加入队列
        queue.offer(pRoot);
        //表示下一层节点的个数
        int nextLayer = 0;
        //表示当前层还没有打印的节点个数,初始化为1，表示第一层
        int toBePrinted = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        while(!queue.isEmpty()) {

            TreeNode temp = queue.poll();
            arr.add(temp.val);
            if(temp.left!=null){
                queue.offer(temp.left);
                nextLayer++;
            }
            if(temp.right!=null){
                queue.offer(temp.right);
                nextLayer++;
            }
            toBePrinted--;
            if(toBePrinted==0){
                //加入arr_all，并清空arr
                arr_all.add(new ArrayList<>(arr));
                arr.clear();
                //toBePrinted赋值为下一层需要打印的节点数
                toBePrinted = nextLayer;
                //打印完后初始化为0
                nextLayer = 0;
            }
        }
        for (ArrayList<Integer> arrayList : arr_all) {
            for (Integer a : arrayList) {
                System.out.print(a + ",");
            }
            System.out.println();
        }
        return arr_all;
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
        offer_60_Print test = new offer_60_Print();
        TreeNode t = test.new TreeNode(1);
        t.left = test.new TreeNode(2);
        t.right = test.new TreeNode(3);
        t.left.left = test.new TreeNode(4);
        t.left.left.right = test.new TreeNode(9);
        t.left.left.right.left = test.new TreeNode(10);
        t.left.left.right.right = test.new TreeNode(11);
        t.left.right = test.new TreeNode(5);
        t.right.left = test.new TreeNode(6);
        t.right.right = test.new TreeNode(7);
        test.Print(t);
    }
}
