package offer;
/*
一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */
public class offer_40_FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length<2){
            return;
        }
        int sum=array[0];
        int flag = 1;
        for(int i=1;i<array.length;i++){
            sum ^= array[i];
        }
        //找到最后一个1
        while((sum&flag)==0){
            flag = flag<<1;
        }
        for(int i=0;i<array.length;i++){
            if((flag&array[i])==0){
                num1[0] ^= array[i];
            }else if((flag&array[i])==flag){
                num2[0] ^= array[i];
            }
        }
        //System.out.println(num1[0] + "," + num2[0]);
    }

    public static void main(String[] args) {
        offer_40_FindNumsAppearOnce test = new offer_40_FindNumsAppearOnce();
        int array[] = {4,7,7,8,8,3,3,9};
        int num1[] = new int[1];
        int num2[] = new int[1];
        test.FindNumsAppearOnce(array, num1, num2);
    }
}
