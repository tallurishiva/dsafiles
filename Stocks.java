import java.util.*;
public class Stocks {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] stocks=new int[n][3];
        for(int i=0;i<n;i++){
            stocks[i][0]=sc.nextInt();
            stocks[i][1]=sc.nextInt();
            stocks[i][2]=sc.nextInt();
        }
        int days=sc.nextInt();
        int[][] market=new int[n][days];
        for(int i=0;i<n;i++){
            for(int j=0;j<days;j++){
                market[i][j]=sc.nextInt();
            }
        }
        int day=sc.nextInt();
        int real=0;
        int unreal=0;
        for(int i=0;i<n;i++){
            if(stocks[i][1]<day){
            if(stocks[i][2]<=day && stocks[i][2]!=0){
                  real+=stocks[i][0]*(market[i][stocks[i][2]-1]-market[i][stocks[i][1]-1]);
            }
            else{
                unreal+=stocks[i][0]*(market[i][day-1]-market[i][stocks[i][1]-1]);
            }
        }}
        System.out.println("real-"+real);
        System.out.println("unreal-"+unreal);
        sc.close();
    }
}
