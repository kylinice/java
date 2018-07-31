package offer;

import java.util.ArrayList;

public class offer_19_printMatrix {
    ArrayList<Integer> arr = new ArrayList<>();
    public ArrayList<Integer> printMatrix(int[][] matrix) {



        if(matrix.length==0){
            return null;
        }
        //列
        int columns = matrix[0].length;
        //行
        int rows = matrix.length;

        int start = 0;

        while(columns>start*2 && rows>start*2){
            PrintMatrixInCircle(matrix, columns, rows, start);
            ++start;
        }

        System.out.println(columns + " " + rows);
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+",");
        }
        return arr;
    }
    public void PrintMatrixInCircle(int [][]matrix, int columns, int rows, int start){
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        //从左到右打印一行, 必定需要这一步
        for(int i=start;i<=endX;++i){
            arr.add(matrix[start][i]);
        }
        //从上到下打印一列，判断是否多行，只有一行则不执行。即终止行号>起始行号
        if(start<endY){
            for(int i=start+1;i<=endY;++i){
                arr.add(matrix[i][endX]);
            }
        }
        //从右到左打印一行，判断是否至少两行两列。即终止行号>起始行号 并且 终止列号>起始列号
        if(start<endX && start<endY){
            for(int i=endX-1;i>=start;--i){
                arr.add(matrix[endY][i]);
            }
        }
        //从下到上打印一列，判断是否三行两列。
        if(start<endX && start+1<endY){
            for(int i=endY-1;i>=start+1;--i){
                arr.add(matrix[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        offer_19_printMatrix test = new offer_19_printMatrix();
        int matrix[][] = {
                {1, 2, 3, 4, 40},
                {5, 6, 7, 8, 40},
                {9, 10, 11, 12, 40},
                {13, 14, 15, 16, 40}
        };
        test.printMatrix(matrix);
    }
}
