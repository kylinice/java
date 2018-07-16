package offer;

import java.time.temporal.Temporal;
import java.util.Arrays;

public class offer_4 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
//        TreeNode root = reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
//        return root;
//    }
//
//
//    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int []in, int startIn, int endIn){
//        if(startPre>endPre|| startIn>endIn){
//            return null;
//        }
//        TreeNode root = new TreeNode(pre[startPre]);
//        for(int i=0; i<in.length; i++){
//            if(in[i]==pre[startPre]){
//                root.left = reConstructBinaryTree(pre, startPre+1, startPre+(i-startIn), in, startIn,i-1);
//                root.right = reConstructBinaryTree(pre, startPre+(i-startIn)+1, endPre, in, i+1, endIn);
//                break;
//            }
//        }
//        return root;
//    }
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int pre[] = {1,2,4,7,3,5,6,8};
        int in[] = {4,7,2,1,5,3,8,6};
        reConstructBinaryTree(pre, in);
    }
}
