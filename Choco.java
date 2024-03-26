import java.util.*;

public class Choco {
     public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<Integer> nums=new ArrayList<>();
        String k=sc.nextLine();
        int n=sc.nextInt();
        String[] str=k.split(" ");
        for(int i=0;i<str.length;i++){
              nums.add(Integer.parseInt(str[i]));
        }
        Collections.sort(nums);
        int i=0;
        int max=1;
        int points=1;
        while(!nums.isEmpty()){
            if(nums.get(i)<=n){
                   n-=nums.get(i);
                   points++;
                   max=max>points?max:points;
                   nums.remove(0);
            }
            else if(points==0 && nums.get(0)>n){
                break;
            }
            else{
                  n+=nums.get(nums.size()-1);
                  points--;
                  nums.remove(nums.size()-1);
            }
        }
        System.out.println(max);
        sc.close();
}
}