import java.util.*;

public class Traffic {
    public static int find(int[][] map, int[][] dp, int i, int j, int x2, int y2, int n, int m) {
        if(i>x2 || j>y2){
            return -1;
        }
        if (i == x2 && j == y2) {
            return map[i][j];
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        
        if (i + 1 < n ) {
            int x=find(map, dp, i + 1, j, x2, y2, n, m);
            if(x!=-1){
            dp[i][j] = Math.min(map[i][j] + x, dp[i][j]);}
        }
        if (j + 1 < m ) {
            int x=find(map, dp, i , j+1, x2, y2, n, m);
            if(x!=-1){
                dp[i][j] = Math.min(map[i][j] + x, dp[i][j]);}
        }
        if(dp[i][j]==Integer.MAX_VALUE) dp[i][j]=-1;
        return dp[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        int x1 = sc.nextInt() - 1;
        int y1 = sc.nextInt() - 1;
        int x2 = sc.nextInt() - 1;
        int y2 = sc.nextInt() - 1;
        dp[x2][y2] =map[x2][y2];
        if(x2 < x1 || y2 < y1 || x2 >= n || y2 >= m){
            int sol = -1;
            System.out.println(sol);
        }
        for(int i=0;i<j)
        System.out.println(sol);
        sc.close();
    }
}
