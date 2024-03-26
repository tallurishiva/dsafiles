import java.util.*;
public class Peak{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] a=new int[2][n];
        for(int i=0;i<n;i++){
            a[0][i]=sc.nextInt();
            a[1][i]=sc.nextInt();
        }
        double start = 0;
        double end = 2 * Math.PI;
        double step = 0.01;
        ArrayList<Double> peaks = findLocalPeaks(a,start, end, step);
        int k=0;
        double max=0;
        for (int i=1;i<peaks.size();i++) {
            if(max<Math.abs(peaks.get(i-1)-peaks.get(i))){
                k=i;
            }
        }
        System.out.println(k);
    }

    public static ArrayList<Double> findLocalPeaks(int[][] a,double start, double end, double step) {
        ArrayList<Double> peaks = new ArrayList<>();
        double x = start + step;
        
        int k=0;
        while (x < end - step) {
            double prev = function(a, x - step);
            double current = function(a, x);
            double next = function(a, x + step);
            if(k==0){
                if(current > next) peaks.add(start);
                k=1;
            }
            if (current > prev && current > next) {
                peaks.add(x);
            }
            x += step;
        }
        return peaks;
    }

    public static double function(int[][] a, double x) {
        double y=0;
        for(int i=0;i<a[0].length;i++){
             y+=Math.sin(a[0][i]*x+a[1][0]);
        }
        return y;
    }
}
