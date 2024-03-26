import java.util.Arrays;
import java.util.Scanner;

public class Task {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String a1=sc.nextLine();
        int[] s=new int[s1.length()];
        int[] a=new int[a1.length()];
        int i=0;
        int j=0;
        while(i<s.length || j<a.length){
            if(i<s.length){
                s[i]=(int)(s1.charAt(i));
                i++;
            }
            if(j<a.length){
                a[j]=(int)(a1.charAt(j));
                j++;
            }
        }
        
        int max=0;
        Arrays.sort(s);
        for(int k=0;k<a.length;k++){
            int p=Arrays.binarySearch(s,a[k]);
            int x1=Integer.MAX_VALUE;
            int x2=Integer.MAX_VALUE;
            int x3=Integer.MAX_VALUE;
            if(p<0){
                p=(-1)*p-1;
                if(p<s.length){
                   x1=Math.abs(s[p]-a[k]);
                }
                if(p==s.length && p<s.length){
                    x3=Math.abs(s[p-1]-a[k]);
                }
                if((p-1)>=0){
                   x2=Math.abs(s[p-1]-a[k]);
                }

                max+=Math.min(x1,Math.min(x2,x3));
            }
            
        }
         
        System.out.println(max);
    }
}
