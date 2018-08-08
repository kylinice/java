package offer;
/*
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class offer_10_RectCover {
    public static int RectCover(int target) {
        int s=0,a=1,b=2;
        if(target<=2){
            return target;
        }
        while(target>=3){
            s = a + b;
            a = b;
            b = s;
            target--;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(RectCover(4));
    }
}
