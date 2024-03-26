import java.util.*;
public class Smith {
    public static void mark(int[] arr,int m,int n){
         int i=m-1;
         int j=m+1;
         int x=n;
         int y=n;
         arr[m]=1;
         while(i>=0 && x>0){
            arr[i]=1;
            i--;
            x--;
            
         }
         while(j<100 && y>0){
            arr[j]=1;
            j++;
            y--;
         }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int m=sc.nextInt();
            int x=sc.nextInt();
            int y=sc.nextInt();
            int[] arr=new int[m];
            for(int j=0;j<m;j++){
               arr[j]=sc.nextInt();
            }
            int occ=x*y;
            int[] temp=new int[100];
            for(int j=0;j<m;j++){
                mark(temp,arr[j]-1,occ);
            }
            int sol=0;
            for(int j=0;j<100;j++){
                if(temp[j]==0) sol++;
            }
            System.out.println(sol);
        }
    }
}
