package test;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class remain_two_decimal {
    double t = 3.1415926;
    public void m1(){
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(t));
    }

    public void m2(){
        System.out.println(String.format("%.2f",t));
    }

    public void m3() {
        BigDecimal bg = new BigDecimal(t);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }

    public void m4() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(t));
    }
    public static void main(String[] args) {
        remain_two_decimal test = new remain_two_decimal();
        test.m1();
        test.m2();
        test.m3();
        test.m4();
    }
}
