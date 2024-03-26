import java.util.*;
public class Good{
    public static void main(String[] args){
        HashMap<Character,Integer> count=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int max=0;
        for(int i=0;i<str.length();i++){
            if(count.containsKey(str.charAt(i))){
                count.put(str.charAt(i),count.get(str.charAt(i))+1);
                max=max>count.get(str.charAt(i))?max:count.get(str.charAt(i));
            }
            else{
                count.put(str.charAt(i),1);
                max=(max==0)?1:max;
            }
        }
        int output=str.length()-max;
        System.out.println(output);
    }
}