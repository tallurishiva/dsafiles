import java.util.*;

public class Assault {
    public static int find(int[][] land, int n, int m, int[][] g) {
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] != 0) {
                    Queue<int[]> que = new LinkedList<>();
                    c++;
                    int[] a = {i, j};
                    que.add(a);
                    while (!que.isEmpty()) {
                        int[] b = que.poll();
                        g[b[0]][b[1]] = 0;
                        if (b[0] + 1 < n && g[b[0] + 1][b[1]] == land[i][j]) {
                            int[] c0 = {b[0] + 1, b[1]};
                            que.add(c0);
                        }
                        if (b[0] - 1 >= 0 && g[b[0] - 1][b[1]] == land[i][j]) {
                            int[] c1 = {b[0] - 1, b[1]};
                            que.add(c1);
                        }
                        if (b[1] + 1 < m && g[b[0]][b[1] + 1] == land[i][j]) {
                            int[] c2 = {b[0], b[1] + 1};
                            que.add(c2);
                        }
                        if (b[1] - 1 >= 0 && g[b[0]][b[1] - 1] == land[i][j]) {
                            int[] c3 = {b[0], b[1] - 1};
                            que.add(c3);
                        }
                    }
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] land = new int[n][m];
        int[][] g = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                land[i][j] = sc.nextInt();
                g[i][j] = land[i][j];
            }
        }

        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int height = sc.nextInt();
        if (land[b1][b2] != 0) {
            System.out.println("NONE");
        } else {
            int c1 = find(g, n, m, g);
            Queue<int[]> que = new LinkedList<>();
            int[] a = {b1, b2};
            que.add(a);
            while (!que.isEmpty()) {
                int[] b = que.poll();
                land[b[0]][b[1]] = 0;
                if (b[0] + 1 < n && land[b[0] + 1][b[1]] <= height && land[b[0] + 1][b[1]] != 0) {
                    int[] c = {b[0] + 1, b[1]};
                    que.add(c);
                }
                if (b[0] - 1 >= 0 && land[b[0] - 1][b[1]] <= height && land[b[0] - 1][b[1]] != 0) {
                    int[] c = {b[0] - 1, b[1]};
                    que.add(c);
                }
                if (b[1] + 1 < m && land[b[0]][b[1] + 1] <= height && land[b[0]][b[1] + 1] != 0) {
                    int[] c = {b[0], b[1] + 1};
                    que.add(c);
                }
                if (b[1] - 1 >= 0 && land[b[0]][b[1] - 1] <= height && land[b[0]][b[1] - 1] != 0) {
                    int[] c = {b[0], b[1] - 1};
                    que.add(c);
                }
            }

            int c2 = find(land, n, m, land);
            if (c1 - c2 == 0) {
                System.out.println("NONE");
            } else {
                System.out.println(c1 - c2);
            }
        }
        sc.close();
    }
}
