import java.util.*;
/**
 * You play a computer game. Your character stands on some level of a multilevel ice cave. In order
 * to move on forward, you need to descend one level lower and the only way to do this is to fall
 * through the ice. The level of the cave where you are is a rectangular square grid of n rows and m
 * columns. Each cell consists either from intact or from cracked ice. From each cell you can move to
 * cells that are side-adjacent with yours (due to some limitations of the game engine you cannot
 * make jumps on the same place, i.e. jump from a cell to itself). If you move to the cell with
 * cracked ice, then your character falls down through it and if you move to the cell with intact ice,
 * then the ice on this cell becomes cracked. Let's number the rows with integers from 1 to n from top
 * to bottom and the columns with integers from 1 to m from left to right. Let's denote a cell on the
 * intersection of the r-th row and the c-th column as (r,c). You are staying in the cell (r1,c1) and
 * this cell is cracked because you've just fallen here from a higher level. You need to fall down
 * through the cell (r2,c2) since the exit to the next level is there. Can you do this?
 * If you can reach the destination, print 'YES', otherwise print 'NO'.
 * Ex1
 *  input
 *  4 6
 *  X...XX
 *  ...XX.
 *  .X..X.
 *  ......
 *  1 6
 *  2 2
 *  output
 *  YES
 * Ex2
 *  input
 *  5 4
 *  .X..
 *  ...X
 *  X.X.
 *  ....
 *  .XX.
 *  5 3
 *  1 1
 *  output
 *  NO
 *  */
public class L05P07 {
    static final int MAX = 500 + 1;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int n, m;
    static char[][] level = new char[MAX][MAX];

    static class Cell {
        int r, c;

        public Cell(int _r, int _c) {
            this.r = _r;
            this.c = _c;
        }
    };

    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    public static boolean BFS(Cell s, Cell f) {
        Queue<Cell> q = new LinkedList<>();
        level[s.r][s.c] = 'X';
        q.add(s);

        while (!q.isEmpty()) {
            Cell u = q.poll();

            for (int i = 0; i < 4; i++) {
                int r = u.r + dr[i];
                int c = u.c + dc[i];

                if (r == f.r && c == f.c && level[r][c] == 'X') {
                    return true;
                }

                if (isValid(r, c) && level[r][c] == '.') {
                    level[r][c] = 'X';
                    q.add(new Cell(r, c));
                }
            }
        }

        return false;
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            level[i] = sc.next().toCharArray();
        }

        Cell s = new Cell(sc.nextInt() - 1, sc.nextInt() - 1);
        Cell f = new Cell(sc.nextInt() - 1, sc.nextInt() - 1);

        System.out.print(BFS(s, f) ? "YES" : "NO");
    }
}
