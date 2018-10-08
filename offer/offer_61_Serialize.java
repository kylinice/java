package offer;
/*
请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class offer_61_Serialize {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public String Serialize(TreeNode root){
        if(root==null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Serialize1(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    public void Serialize1(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("$,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        Serialize1(root.left, sb);
        Serialize1(root.right, sb);
    }
    public TreeNode Deserialize(String str){
        if(str.length()==0){
            return null;
        }
        String[] strs = str.split(",");
        for(String string:strs){
            System.out.print(string + "|");
        }
        return Deserialize1(strs);
    }
    int index = -1;
    public TreeNode Deserialize1(String[] strs){
        index++;
        if(!strs[index].equals("$")){
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = Deserialize1(strs);
            root.right = Deserialize1(strs);
            return root;
        }
        return null;
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
        offer_61_Serialize test = new offer_61_Serialize();
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
        test.Deserialize(test.Serialize(t));
    }
}
