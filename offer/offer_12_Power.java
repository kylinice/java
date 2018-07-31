package offer;

public class offer_12_Power {
    public double Power(double base, int exponent) {
        if(exponent<0){
            base = 1/base;
            exponent = -exponent;
        }
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        if(exponent % 2 ==0){
            return Power(base*base, exponent/2);
        }else{
            return base*Power(base*base, exponent/2);
        }
    }
    public double offer_pow(double base, int exponent) {

        double res = Helper(base, Math.abs(exponent));
        if (exponent < 0) {
            res = 1.0 / res;
        }
        return res;
    }

    private double Helper(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double res = offer_pow(base, exponent >> 1);
        res *= res;
        if ((exponent & 0x1) == 1) {
            res *= base;
        }
        return res;
    }

    public static void main(String[] args) {
        offer_12_Power test = new offer_12_Power();
        System.out.println(test.Power(2,-3));
        System.out.println(test.offer_pow(2,-3));
    }
}
