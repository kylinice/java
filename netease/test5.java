package netease;

import java.util.Scanner;

public class test5 {
    public static void find(int m, int[] answer){
        int len = answer.length-1;
        int low = 0;
        int high = len;
        while (low<=high){
            int mid = (low+high)/2;
            if(m==answer[mid]){
                System.out.println(mid+1);
                break;
            }else if(m>answer[mid]){
                low = mid+1;
                if(m<=answer[low]){
                    System.out.println(low+1);
                    break;
                }
            }else{
                high = mid-1;
                if(high==-1){
                    System.out.println(1);
                    break;
                }else{
                    if(m>answer[high]){
                        System.out.println(high+2);
                        break;
                    }
                }
            }
        }

    }
    /*
5
1 7 3 4 9
24
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int answer[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
            if(i==0){
                answer[i]=a[i];
            }else {
                int temp = answer[i-1];
                answer[i] = temp + a[i];
            }
        }
        int m = in.nextInt();
        int q[] = new int[m];
        for(int i=0;i<m;i++){
            q[i] = in.nextInt();
        }

        for(int i=0;i<m;i++){
            find(q[i],answer);
        }
    }
}
