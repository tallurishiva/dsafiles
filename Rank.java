import java.util.*;

class Rank{
    public static boolean isprime(int n){
        int c=0;
        for(int i=1;i<=n;i++){
            if(n%i==0) c++;
        }
        if(c==2) return true;
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        //int d=(int)('a')-(int)('b');
        int s=0;
        int c=0;
        int i=2;
        while(s<k){
            if(isprime(i) && isprime(s+i)){
                s+=i;
                c++;
            }
            i++;
        }
        System.out.println("no of primes-:"+c);
        sc.close();
    }
}