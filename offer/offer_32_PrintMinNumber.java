package offer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        Collections.sort(array, (o1, o2) -> {
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
