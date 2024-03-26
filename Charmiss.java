import java.util.*;
public class Charmiss{
    public static void findErrors(char[] charset) {
            int n=charset.length;
            if(charset[0]!='a'){
                System.out.println("["+charset[0]+",a]");
                return;
            }
            else{
                for(int i=1;i<n;i++){
                    if((int)(charset[i])!=((int)(charset[i-1])+1)){
                        System.out.println("["+charset[i-1]+","+(char)(((int)charset[i-1])+1)+"]");
                        return;
                    }
                }
            }
        }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            String inputLine = scanner.nextLine();
            
            char[] charset = inputLine.replaceAll("\\s", "").toCharArray();
            Arrays.sort(charset);
            findErrors(charset);
        }
    }
}