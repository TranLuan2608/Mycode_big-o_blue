import java.util.*;
    /**
     * Mr.ESP used to tell ALL IZZ WELL whenever he gets into any trouble. So his friends and the
     * people around him used to laugh at him. But Mr.ESP is very strong in his belief. He believes
     * that the term ALL IZZ WELL will make everything fine. Now your task is to ignore the story
     * above and find whether there is a path in the given matrix which makes the sentence ALL IZZ WELL.
     *
     * There is a path from any cell to all its neighbouring cells. A neighbour may share an edge or a corner.
     *
     * For each test case print YES if there is a path which makes the sentence ALLIZZWELL. Else print NO.
     *
     * Ex1
     *  input
     *  5
     *  3 6
     *  AWE.QX
     *  LLL.EO
     *  IZZWLL
     *
     *  1 10
     *  ALLIZZWELL
     *
     *  2 9
     *  A.L.Z.E..
     *  .L.I.W.L.
     *
     *  3 3
     *  AEL
     *  LWZ
     *  LIZ
     *
     *  1 10
     *  LLEWZZILLA
     *  output
     *  YES
     *  YES
     *  NO
     *  NO
     *  YES
     *  */

public class L06P06 {
    static final int MAX = 101;
    static String term = "ALLIZZWELL";
    static int R, C;
    static boolean found;
    static int[] dr = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dc = {1, -1, 0, 1, -1, 0, 1, -1};
    static boolean[][] visited = new boolean[MAX][MAX];
    static char[][] table = new char[MAX][MAX];

    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    public static void DFS(int sr, int sc, int count) {
        if (count == term.length()) {
            found = true;
            return;
        }

        for (int i = 0; i < 8; i++) {
            int r = sr + dr[i];
            int c = sc + dc[i];

            if (isValid(r, c) && table[r][c] == term.charAt(count) && !visited[r][c]) {
                visited[r][c] = true;
                DFS(r, c, count + 1);
                visited[r][c] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            R = sc.nextInt();
            C = sc.nextInt();

            for (int i = 0; i < R; i++) {
                table[i] = sc.next().toCharArray();
                for (int j = 0; j < C; j++) {
                    visited[i][j] = false;
                }
            }

            found = false;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (table[i][j] == term.charAt(0) && !found) {
                        DFS(i, j, 1);
                    }
                }
            }

            System.out.println(found ? "YES" : "NO");
        }
    }
}
