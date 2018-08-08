package offer;
/*
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
import java.util.ArrayList;

public class offer_32_PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        int len = numbers.length;
        if(len==1){
            return String.valueOf(numbers[0]);
        }
        ArrayList<Integer> array = new ArrayList<>();
        for(int i=0;i<len;i++){
            array.add(numbers[i]);
        }
        array.sort((o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s1.compareTo(s2);
        });
        StringBuilder strbuild = new StringBuilder();
        for(int num : array){
            strbuild.append(num);
        }
        return strbuild.toString();
    }
//    Collections.sort(array, new Comparator<Integer>() {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            String s1 = o1 + "" + o2;
//            String s2 = o2 + "" + o1;
//            return s1.compareTo(s2);
//        }
//    });

    public static void main(String[] args) {
        offer_32_PrintMinNumber test = new offer_32_PrintMinNumber();
        int a[] = {3, 31, 321};
        System.out.println(test.PrintMinNumber(a));
    }
}
