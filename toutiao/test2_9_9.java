package toutiao;

import java.util.Scanner;

public class test2_9_9 {
    //对应上下左右
    static int[] dx = {0, 0, -1, 1};
    static int[] dy=  {1, -1, 0, 0};
    public static void find(int[][] a){
        int ans = 0;
        int col = a[0].length;
        int row = a.length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(a[i][j] == 1){
                        dfs(a, i, j);
                        ans++;
                }
            }
        }
        System.out.println(ans);
    }
    public static void dfs(int[][] a, int i, int j){
        //将访问过的设置为0
        a[i][j] = 0;
        // 上下左右进行dfs
        for(int k=0;k<4;k++){
            int dir_x = i + dx[k];
            int dir_y = j + dy[k];
            //如果越界
            if(dir_x<0 || dir_x>=a.length || dir_y<0 || dir_y>=a[0].length){
                continue;
            }
            if(a[dir_x][dir_y]==0){
                continue;
            }
            dfs(a, dir_x, dir_y);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[][] a = new int[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                a[i][j] = in.nextInt();
            }
        }
        find(a);
    }
}
/*
5
1 1 0 0 0
1 1 0 1 0
0 0 1 1 1
0 0 0 0 0
1 1 0 0 1
2
1 1
1 1
 */