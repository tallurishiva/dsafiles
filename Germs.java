import java.util.Scanner;

public class Germs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of dishes
        sc.nextLine(); // consume the remaining newline character

        String input = sc.nextLine(); // read the entire dish information
        String[] dishesStr = input.split(" "); // split individual dish information

        int[][] dishes = new int[n][2]; // initialize 2D array for dishes

        // parse individual dish information
        for (int i = 0; i < n; i++) {
            String[] dishInfo = dishesStr[i].split(":");
            dishes[i][0] = Integer.parseInt(dishInfo[0]); // id
            dishes[i][1] = Integer.parseInt(dishInfo[1]); // rating
        }

        int maxGems = getMaxGems(dishes);
        System.out.println(maxGems);

        sc.close();
    }

    private static int getMaxGems(int[][] dishes) {
        int maxMinGems = 0;
        int maxMaxGems = 0;
        int minSoFar = Integer.MAX_VALUE;
        int maxSoFar = Integer.MIN_VALUE;

        for (int[] dish : dishes) { // iterate using enhanced for loop
            minSoFar = Math.min(minSoFar, dish[0]);
            maxSoFar = Math.max(maxSoFar, dish[0]);

            maxMinGems += dish[1];
            maxMaxGems += dish[1];

            if (dish[0] == minSoFar) {
                maxMinGems = Math.max(maxMinGems, maxMaxGems - dish[1] + minSoFar);
            } else if (dish[0] == maxSoFar) {
                maxMaxGems = Math.max(maxMinGems + dish[1] - maxSoFar, maxMaxGems);
            }
        }

        return Math.max(maxMinGems, maxMaxGems);
    }
}
