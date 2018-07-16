package offer;

public class offer_8 {
    public static int JumpFloor(int n) {
        int s=0,a=1,b=2;
        if(n<=2){
            return n;
        }
        while(n>2){
            s = a + b;
            a = b;
            b = s;
            n--;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(6));
    }
}
