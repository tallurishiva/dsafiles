import java.util.*;
public class Rat {
    public static void dfs(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
            return;
        }
        grid[row][col] = 0; 
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int b=sc.nextInt();
        int[][] cods=new int[b][4];
        for(int i=0;i<b;i++){
           for(int j=0;j<4;j++){
               cods[i][j]=sc.nextInt();
           }
        }
        int[][] bord=new int[2*n+1][2*m+1];
        for(int i=0;i<2*n+1;i++){
            Arrays.fill(bord[i],1);
        }
        for(int i=0;i<b;i++){
            if(cods[i][0]==cods[i][2]){
                int x=2*cods[i][0];
                for(int j=2*cods[i][1];j<=2*cods[i][3];j++){
                    bord[x][j]=0;
                }
            }
            if(cods[i][0]!=cods[i][2]){
                int x=2*cods[i][1];
                for(int j=2*cods[i][0];j<=2*cods[i][2];j++){
                    bord[j][x]=0;
                }
            }
        }
        int sol=0;
        int q=bord[0].length;
        for(int i=0;i<2*n+1;i++){
            if(bord[i][0]==1){
                sol++;
                dfs(bord,i,0);
            }
            if(bord[i][q-1]==1){
                sol++;
                dfs(bord,i,q-1);
            }
        } 
        q=bord.length;
        for(int i=0;i<2*m+1;i++){
            if(bord[0][i]==1){
                sol++;
                dfs(bord,0,i);
            }
            if(bord[q-1][i]==1){
                sol++;
                dfs(bord,q-1,i);
            }
        }
        int y=0;
        for(int i=0;i<2*n+1;i++){
            for(int j=0;j<2*m+1;j++){
                if(bord[i][j]==1){
                    y++;
                    dfs(bord,i,j);
                }
            }
        } 
        float z=(float)sol/(sol+y);
        int k=Math.round(z);
        System.out.println(k);
    }
}
