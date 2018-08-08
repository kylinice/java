package offer;
import java.util.Arrays;
public class offer_45_isContinuous {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length<1){
            return false;
        }
        Arrays.sort(numbers);
        int len = numbers.length;
        int numOfZero = 0;
        int numOfGap = 0;
        //统计0的个数
        for(int i=0;i<len;i++){
            if(numbers[i]==0){
                numOfZero++;
            }
        }
        //统计数组中间隔数目
        int small = numOfZero;
        int big = small+1;
        while(big<len){
            //如果是对子
            if(numbers[small]==numbers[big]){
                return false;
            }
            //计算需要癞子的个数
            numOfGap += numbers[big]-numbers[small]-1;
            small = big;
            big++;
        }
        return (numOfZero>=numOfGap)?true:false;
    }

    public static void main(String[] args) {
        offer_45_isContinuous test = new offer_45_isContinuous();
        int a[] = {0,2,1,3,5};
        System.out.println(test.isContinuous(a));
    }

}
