package tencent;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test3_set {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n>0){
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            Set<Integer> set = new HashSet<>();
            int mod = A%B;
            set.add(mod);
            while(mod!=C){
                mod = (mod + A%B)%B;
                if(set.contains(mod)){
                    break;
                }
            }
            System.out.println(mod==C?"Yes":"No");
            n--;
        }
    }
}
