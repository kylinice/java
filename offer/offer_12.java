package offer;

public class offer_12 {
    public double Power(double base, int exponent) {
        if(exponent<0){
            base = 1/base;
            exponent = -exponent;
        }
        if(exponent == 0){
            return 1;
        }
        if(exponent % 2 ==0){
            return Power(base*base, exponent/2);
        }else{
            return base*Power(base*base, exponent/2);
        }
    }

    public static void main(String[] args) {
        offer_12 test = new offer_12();
        System.out.println(test.Power(2,-2));
    }
}
