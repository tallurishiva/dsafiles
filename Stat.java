import java.util.*;
public class Stat {
     private int a;
     private int b;
     Stat(int x,int y){
        this.a=x;
        this.b=y;
     }
    //public abstract  int sub();
    public int add(){
        return a+b;
    }
    public  int add(int x,int y){
        return x+y;
   }
    public static void main(String[] args) {
        System.out.println("srk");
       Stat obj=new Stat(1, 2);
       Stat obj1=new Stat(5, 6);
       System.out.println(obj.a);
       System.out.println(obj.add());
       System.out.println(obj1.add());
        System.out.println(obj.add(1,4));
    }

}
