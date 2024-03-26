import java.util.Scanner;

public class Prefixsum {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
    }
    for(int i=1;i<n;i++){
        arr[i]=arr[i]+arr[i-1];
    }
    int[] res=new int[n];
     for(int i=0;i<n;i++){
        if(i==n-1){
            res[i]=arr[i];
        }
        else{
        res[i]=Math.abs(arr[i]-(arr[n-1]-arr[i]));}
     }
     System.out.println("result array");
     for(int i=0;i<n;i++){
        System.out.println(res[i]);;
    }
}
}