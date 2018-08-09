package offer;

import java.util.ArrayList;
import java.util.Arrays;

/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
不能使用除法。
 */
public class offer_51_multiply {
    public int[] multiply(int[] A) {
        int B[] = new int[A.length];
        if(A.length<=1){
            return B;
        }
        B[0] = 1;
        for(int i=1;i<=A.length-1;i++){
            B[i] = B[i-1] * A[i-1];
        }
        int temp = 1;
        for(int i=A.length-2;i>=0;i--){
            temp = A[i+1] * temp;
            B[i] = B[i] * temp;
        }
        return B;
    }

    public static void main(String[] args) {
        offer_51_multiply test = new offer_51_multiply();
        int a[] = {};
        System.out.println(Arrays.toString(test.multiply(a)));
    }
}
