package DataStructure;
//求指定数组中，和为n的出现的所有组合
public class deal_sum {
    public static void deal_sum(int[] a, int val){
        if(a.length==0){
            return;
        }
        int count = 1;
        int len = a.length;
        int m = len;
        //背包数组
        int[] b = new int[len];
        while(m--!=0){
            count *= 2;
        }
        while(count--!=0){
//            for(int i=0;i<len;i++){
//                if(b[i]==0){
//                    b[i]=1;
//                }else{
//                    b[i]=0;
//                    break;
//                }
//            }
            for(int i=len-1;i>=0;i--){
                if(b[i]==0){
                    b[i]=1;
                }else{
                    b[i]=0;
                    break;
                }
            }
            int sum=0;
            for(int i=0;i<len;i++){
                if(b[i]==1){
                    sum += a[i];
                }
            }
            if(sum==val){
                for(int i=0;i<len;i++){
                    if(b[i]==1){
                        System.out.print(a[i] + ",");
                    }
                }
                System.out.println();
            }
        }


    }
    public static void main(String[] args) {
        int[] a = {6,7,8,9,10,11,12,1,2,3,4,5,34,6};
        int[] b = {1,2,3,4,5,6,7};
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] b = new int[n];
//        for(int i=0;i<n;i++){
//            b[i] = i+1;
//        }
        deal_sum(b, 7);
    }
}
