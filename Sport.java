import java.util.*;

public class Sport {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String st=sc.nextLine();
        String[] str=st.split(" ");
        int[] nums=new int[str.length];
        int d=0;
        for(int i=0;i<str.length;i++){
              nums[i]=Integer.parseInt(str[i]);
              if(nums[i]<0) d++;
        }
        Arrays.sort(nums);
        int sum=0;
        int k=0;
        if(nums[nums.length-1]<0){
            System.out.println(0);
        }
        else{
        for(int i=0;i<nums.length;i++){
            k=0;
            int p=1;
            for(int j=i;j<nums.length;j++){
                k+=nums[j]*p;
                p++;
            }
            sum=sum>k?sum:k;
        }
        System.out.println(sum);}
}
}
