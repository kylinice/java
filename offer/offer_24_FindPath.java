package offer;

import java.util.ArrayList;

public class offer_24_FindPath {

    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
    ArrayList<ArrayList<Integer>> arr_all = new ArrayList<>();
    ArrayList<Integer> arr = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null){
            return arr_all;
        }
        arr.add(root.val);
        target = target - root.val;
        //如果是叶子节点 且 符合条件, 创建新的list代表
        if(target==0 && root.left==null && root.right==null){
            arr_all.add(new ArrayList<>(arr));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        arr.remove(arr.size()-1);
        return arr_all;
    }



    public static void main(String[] args) {
        offer_24_FindPath test = new offer_24_FindPath();
        offer_24_FindPath.TreeNode t = test.new TreeNode(1);
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

        ArrayList<ArrayList<Integer>> air = new ArrayList<>();
        air = test.FindPath(t, 11);
        for (int i = 0; i < air.size(); i++) {
            for(int j=0;j<air.get(i).size();j++){
                System.out.print(air.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }
}
