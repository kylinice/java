package offer;

public class offer_23_VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        if(sequence.length==1){
            return true;
        }
        int length = sequence.length;
        return judge(sequence, 0, length-1);

    }
    public boolean judge(int []sequence, int start, int root){
        if(start>=root){
            return true;
        }
        int node = sequence[root];
        //在二叉搜索树中左子树节点的值小于根节点的值
        int i = start;
        for(;i<root;i++){
            if(sequence[i]>node){
                break;
            }
        }
        //System.out.println(i);
        //在二叉搜索树中右子树节点的值大于根节点的值
        int j=i;
        for(;j<root;j++){
            if(sequence[j]<node){
                return false;
            }
        }
        //判断左子树是不是二叉搜索树
        boolean left = judge(sequence,start,i-1);
        boolean right = judge(sequence,i,root-1);

        return (left&&right);
    }


    public static void main(String[] args) {
        offer_23_VerifySquenceOfBST test = new offer_23_VerifySquenceOfBST();
        int a[] = {5,7,6,9,11,10,8};
        System.out.println(test.VerifySquenceOfBST(a));
    }
}
