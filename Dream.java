import java.util.*;
public class Dream {
    public static int find(int[][] dp,List<List<int[]>> map,int i,int n,int j,int bat,int bow,int all,int wi){
        if(i>=map.size() || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        List<int[]> a=map.get(i);
        dp[i][j]=0;
        for(int k=0;k<a.size();k++){
            int[] b=a.get(k);
            if(b[1]<=j && b[2]==0){
                b[2]=1;
                if(i==0 && wi==1){
                dp[i][j]=Math.max(b[0]+find(dp,map,i+1,n-1,j-b[1],bat,bow,all,wi-1),dp[i][j]);
                int m=n;
                while()
            }
                if(i==1 && bat>1){
                    dp[i][j]=Math.max(b[0]+find(dp,map,i,n-1,j-b[1],bat-1,bow,all,wi-1),dp[i][j]);}
                if(i==1 && bat==1){
                        dp[i][j]=Math.max(b[0]+find(dp,map,i+1,n-1,j-b[1],bat-1,bow,all,wi-1),dp[i][j]);}
                b[2]=0;
            }
        }
        return dp[i][j];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] p=new int[n];
        int[] val=new int[n];
        int[] sel=new int[n];
        for(int i=0;i<n;i++){
            p[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        int bud=sc.nextInt();
        List<List<int[]>> map=new ArrayList<>();
        int wik=n/5;
        if(n%5!=0){
           wik++;
        }
        int[][] dp=new int[4][bud+1];
        for(int i=0;i<4;i++){
            Arrays.fill(dp[i],-1);
            map.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(n<wik){
                int[] a={p[i],val[i],sel[i]};
                map.get(0).add(a);
            }
            else{
                if((i+1)%4==0){
                    int[] a={p[i],val[i],sel[i]};
                    map.get(3).add(a);
                }
                else{
                if((i+1)%2==0){
                    int[] a={p[i],val[i],sel[i]};
                    map.get(1).add(a);
                }
                else{
                    int[] a={p[i],val[i],sel[i]};
                    map.get(3).add(a);
                }
            }
            }
        }
        int maxdam=find(dp,map,0,11,bud,2,2,1,1);
    }
}
