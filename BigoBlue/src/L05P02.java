import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
    /**
     * There are many algorithms to generate maze (Maze Generation Algorithm). After generating
     * the maze we’ve to validate whether it’s a valid maze or not. A valid maze has exactly
     * one entry point and exactly one exit point (exactly 22 openings in the edges) and there must
     * be atleast one path from the entry point to exit point.
     * Given a maze, just find whether the maze is "validvalid" or "invalidinvalid".
     * Ex
     *  input
     *  6
     *  4 4
     *  ####
     *  #...
     *  #.##
     *  #.##
     *  5 5
     *  #.###
     *  #..##
     *  ##..#
     *  #.#.#
     *  ###.#
     *  1 1
     *  .
     *  5 1
     *  #
     *  #
     *  .
     *  .
     *  #
     *  2 2
     *  #.
     *  .#
     *  3 4
     *  #..#
     *  #.##
     *  #.##
     *  output
     *  valid
     *  valid
     *  invalid
     *  valid
     *  invalid
     *  invalid
     *  */
public class L05P02 {
    static final int MAX = 21;
    static int dr[] = {0, 0, 1, -1};
    static int dc[] = {1, -1, 0, 0};
    static int n, m;
    static boolean visited[][] = new boolean[MAX][MAX];
    static String maze[] = new String[MAX];
 
    static class Cell {
        int r, c;
 
        public Cell(int _r, int _c) {
            r = _r;
            c = _c;
        }
    };
 
    public static boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
 
    public static boolean BFS(Cell s, Cell f) {
        Queue<Cell> q = new LinkedList<>();
        visited[s.r][s.c] = true;
        q.add(s);
 
        while (!q.isEmpty()) {
            Cell u = q.poll();
 
            if (u.r == f.r && u.c == f.c) {
                return true;
            }
 
            for (int i = 0; i < 4; i++) {
                int r = u.r + dr[i];
                int c = u.c + dc[i];
 
                if (isValid(r, c) && maze[r].charAt(c) == '.' && !visited[r][c]) {
                    visited[r][c] = true;
                    q.add(new Cell(r, c));
                }
            }
        }
 
        return false;
    }
 
    public static void main(String[] agrs) {
        MyScanner in = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int Q = in.nextInt();
 
        while (Q-- > 0) {
            n = in.nextInt();
            m = in.nextInt();
 
            for (int i = 0; i < n; i++) {
                maze[i] = in.nextLine();
            }
 
            ArrayList<Cell> entrance = new ArrayList<>();
 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    visited[i][j] = false;
                    if (maze[i].charAt(j) == '.' && (i == 0 || j == 0 || i == n - 1 || j == m - 1)) {
                        entrance.add(new Cell(i, j));
                    }
                }
            }
 
            if (entrance.size() != 2) {
                out.println("invalid");
            }
            else {
                Cell s = entrance.get(0);
                Cell f = entrance.get(1);
                out.println(BFS(s, f) ? "valid" : "invalid");
            }
        }
    }
 
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
  
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
         
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
         
        int nextInt() {
            return Integer.parseInt(next());
        }
         
        long nextLong() {
            return Long.parseLong(next());
        }
         
        double nextDouble() {
            return Double.parseDouble(next());
        }
         
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
