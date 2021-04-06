import java.util.*;
    /**
     * You will be given a 2-dimensional grid of letters. Find the length of the longest path of
     * consecutive letters, starting at 'A'. Paths can step from one letter in the grid to any adjacent
     * letter (horizontally, vertically, or diagonally). For example, in the following grid, there are several
     * paths from 'A' to 'D', but none from 'A' to 'E':  One such path is:
     * For each test case print “Case C: X” without quotes where C is the case number starting with 1
     * and X is the solution.
     *
     * Ex
     *  input
     *  4 3
     *  ABE
     *  CFG
     *  BDH
     *  ABC
     *  0 0
     *  output
     *  Case 1: 4
     *
     *  Giai thich
     *      Trong ví dụ trên có một vài đường đi từ A đến D nhưng không có đường nào đi từ A đến E, nên
     *      đường đi dài nhất là 4 đi từ A đến D.*/
public class L06P07 {
        static final int maxn = 1000;
        static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        static Scanner sc = new Scanner(System.in);
        static int n, m, ans;
        static int visited[][] = new int[maxn][maxn];
        static String a[] = new String[maxn];

        static int max(int x, int y) {
            if (x > y) return x;
            return y;
        }

        static int dfs(int u, int v) {
            int s = 0;
            for (int i = 0; i < 8; i++) {
                int n_u = u + dx[i];
                int n_v = v + dy[i];
                if (n_u >= 0 && n_u < n && n_v >= 0 && n_v < m)
                    if (a[n_u].charAt(n_v) - a[u].charAt(v) == 1) {
                        if (visited[n_u][n_v] == 0) dfs(n_u, n_v);
                        s = max(s, visited[n_u][n_v]);
                    }
            }
            visited[u][v] = s + 1;
            return visited[u][v];
        }

        public static void main(String[] args) {
            int p = 0;
            while (true) {
                ans = 0;
                n = sc.nextInt();
                m = sc.nextInt();
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m; j++)
                        visited[i][j] = 0;
                if (n * m == 0) break;
                for (int i = 0; i < n; i++)
                    a[i] = sc.next();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (a[i].charAt(j) == 'A') {
                            ans = max(ans, dfs(i, j));
                        }
                    }
                }
                p++;
                System.out.println("Case " + p + ": " + ans);
            }

        }
}
