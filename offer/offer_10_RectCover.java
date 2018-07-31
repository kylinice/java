package offer;

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
