import java.util.*;
public class Sasha{
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    for(int i=0;i<n;i++){
        int m=sc.nextInt();
        int k=sc.nextInt();
        int sol=0;
        if(m>=k/2){
            sol=k/2;
            if(k%2!=0){
                sol++;
            }
        }
        else{
            sol=k/2;
            

        }
        System.out.println(sol);
    }
    sc.close();
}
}