package offer;

import java.util.Scanner;

public class offer_1_Find {
    public boolean Find(int target, int [][] array){
        if(array.length==0){
            return false;
        }
        int col = 0;
        int row = array.length-1;
        while(row>=0 && col<array[0].length){
            if(target==array[row][col]){
                return true;
            }else if(target>array[row][col]){
                col++;
            }else{
                row--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        offer_1_Find test = new offer_1_Find();
        Scanner in = new Scanner(System.in);
        System.out.print("输入行：");
        int row = in.nextInt();
        System.out.print("输入列：");
        int col = in.nextInt();
        int a[][] = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                a[i][j] = in.nextInt();
            }
        }
        System.out.println(test.Find(8,a));
    }
}
