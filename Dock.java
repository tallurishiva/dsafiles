import java.io.*;
import java.util.*;

public class Dock {
    public static boolean validate(int[] arr,int size,int m){
        int n=arr.length;
        int i=0;
        int cur=0;
        //System.out.println(i);
        while(i>=0){
            //System.out.println("val=="+arr[i]);
            if(arr[i]>size){
                   break;
               }
            else if(cur!=0 && cur+arr[i]<=size){
                i--;
                if(m<=0) break;
                m--;
                cur=0;
            }
            else if(cur==0 && m>0){
               cur+=arr[i];
                i--;
            }
            else{
                if(m<=0) break; 
                m--;
                cur=0;
            }
        }
        
        if(i==-1) return true;
        return false;
    }
    public static void main(String[] args){
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[] arr=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=sc.nextInt();
            }
            Arrays.sort(arr);
            if(n==1){
                System.out.println(arr[0]);
            }
            else{
                int min=arr[n-1];
                int sol=0;
                if(validate(arr,arr[n-1],m)){
                    sol=arr[n-1];
                }
                else{
                int j=arr[n-1];
                int max=arr[n-1]+arr[n-2];
                while(j<=max){
                    if(validate(arr,j,m)){
                        sol=j;
                        break;
                    }
                    j++;
                }}
                System.out.println(sol);
            }
        }
    }
}