import java.util.*;
    /**
     * Once there was a king named Akbar. He had a son named Shahjahan. For an unforgivable reason
     * the king wanted him to leave the kingdom. Since he loved his son he decided his son would be
     * banished in a new place. The prince became sad, but he followed his father's will. In the way
     * he found that the place was a combination of land and water. Since he didn't know how to swim,
     * he was only able to move on the land. He didn't know how many places might be his destination.
     * So, he asked your help.
     *
     * For simplicity, you can consider the place as a rectangular grid consisting of some cells.
     * A cell can be a land or can contain water. Each time the prince can move to a new cell from
     * his current position if they share a side.
     *
     * Now write a program to find the number of cells (unit land) he could reach including the
     * cell he was living.
     * Ex
     *  '.' - land
     *  '#' - water
     *  '@' - initial position of prince (appears exactly once in a dataset)
     *  input
     *  4
     *  6 9
     *  ....#.
     *  .....#
     *  ......
     *  ......
     *  ......
     *  ......
     *  ......
     *  #@...#
     *  .#..#.
     *  11 9
     *  .#.........
     *  .#.#######.
     *  .#.#.....#.
     *  .#.#.###.#.
     *  .#.#..@#.#.
     *  .#.#####.#.
     *  .#.......#.
     *  .#########.
     *  ...........
     *  11 6
     *  ..#..#..#..
     *  ..#..#..#..
     *  ..#..#..###
     *  ..#..#..#@.
     *  ..#..#..#..
     *  ..#..#..#..
     *  7 7
     *  ..#.#..
     *  ..#.#..
     *  ###.###
     *  ...@...
     *  ###.###
     *  ..#.#..
     *  ..#.#..
     *  output
     *  Case 1: 45
     *  Case 2: 59
     *  Case 3: 6
     *  Case 4: 13
     *  */
public class L05P04 {
    static final int MAX = 21;
    static int dr[] = {0, 0, 1, -1};
    static int dc[] = {1, -1, 0, 0};
    static int W, H;
    static boolean visited[][] = new boolean[MAX][MAX];
    static String maze[] = new String[MAX];

    static class Cell {
        int r, c;

        public Cell(int _r, int _c) {
            this.r = _r;
            this.c = _c;
        }
    };

    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < H && c < W;
    }

    public static int BFS(Cell s) {
        Queue<Cell> q = new LinkedList<>();
        q.add(s);
        visited[s.r][s.c] = true;
        int count = 1;

        while (!q.isEmpty()) {
            Cell u = q.poll();

            for (int i = 0; i < 4; i++) {
                int r = u.r + dr[i];
                int c = u.c + dc[i];

                if (isValid(r, c) && maze[r].charAt(c) == '.' && !visited[r][c]) {
                    visited[r][c] = true;
                    q.add(new Cell(r, c));
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        Cell s = new Cell(0, 0);

        for (int k = 1; k <= Q; k++) {
            W = sc.nextInt();
            H = sc.nextInt();

            for (int i = 0; i < H; i++) {
                maze[i] = sc.next();

                for (int j = 0; j < W; j++) {
                    if (maze[i].charAt(j) == '@') {
                        s = new Cell(i, j);
                    }

                    visited[i][j] = false;
                }
            }

            System.out.println("Case " + k + ": " + BFS(s));
        }
    }
}
