import java.util.*;
public class Clan {
    public static int find(int[][] dp,List<List<int[]>> map,int i,int j){
        if(i>=map.size() || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        List<int[]> a=map.get(i);
        dp[i][j]=0;
        dp[i][j]=find(dp,map,i+1,j);
        for(int k=0;k<a.size();k++){
            int[] b=a.get(k);
            if(b[1]<=j){
                dp[i][j]=Math.max(b[0]+find(dp,map,i+1,j-b[1]),dp[i][j]);
            }
        }
        return dp[i][j];
    }
    public static void main(String[] args){
          Scanner sc = new Scanner(System.in);
        String[] d = sc.nextLine().split(" ");
        int[] dam = new int[d.length];
        for (int i = 0; i < d.length; i++) {
            dam[i] = Integer.parseInt(d[i]);
        }
        String[] size = sc.nextLine().split(" ");
        int[] s = new int[size.length];
        for (int i = 0; i < size.length; i++) {
            s[i] = Integer.parseInt(size[i]);
        }
        int max=0;
        String[] category = sc.nextLine().split(" ");
        int[] cat = new int[category.length];
        for (int i = 0; i < category.length; i++) {
            cat[i] = Integer.parseInt(category[i]);
            max=max>cat[i]?max:cat[i];
        }
        int n=sc.nextInt();
        List<List<int[]>> map=new ArrayList<>();
        int[][] dp=new int[max][n+1];
        for(int i=0;i<max;i++){
            Arrays.fill(dp[i],-1);
            map.add(new ArrayList<>());
        }
        int m=dam.length;
        for(int i=0;i<m;i++){
             int[] a={dam[i],s[i]};
             map.get(cat[i]-1).add(a);
        }
        int maxdam=find(dp,map,0,n);
        System.out.println("max=>"+maxdam);
}
}