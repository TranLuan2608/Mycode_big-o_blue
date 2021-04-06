import java.util.*;
/**
 * Mirko has a herd of sheep, surrounded by fences backyard. While he was asleep, wolves have sneaked
 * into the fenced area and attacked the sheep. Backyard is of a rectangular shape, and consists of
 * fields arranged in rows and columns. Character '.' (fullstop) represents a blank field. Character '#'
 * represents a fance. Character 'k' represents a sheep. Character 'v' represents a wolf.   Two fields
 * belong to the same sector if we can move from the field A to the field B without going over the
 * fence, by making only horizontal and vertical steps (we cannot move diagonally). If we can escape
 * from field A from the backyard, that field does not belong to any sector. Luckily, Mirko taught
 * his sheep Kung-Fu skills, and they can defend themselves against wolves only if they outnumber
 * the wolves in that sector. When there are more sheep in the sector than wolves, all wolves die
 * without sheep casualties. Otherwise all sheep perish and wolves are unharmed. If a field doesn't
 * belong in any sector, sheep will flee and wolfs will be left without a prey, so every animal survives.
 * Write a program that will determine how many sheep and wolves will survive this bloody night.
 * In the first and the only line, print the number of sheep and wolves that will survive.
 *
 * Ex
 *  input
 *  8 8
 *  .######.
 *  #..k...#
 *  #.####.#
 *  #.#v.#.#
 *  #.#.k#k#
 *  #k.##..#
 *  #.v..v.#
 *  .######.
 *  output
 *  3 1
 *  */
public class L05P08 {
    static final int MAX = 500 + 1;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int N, M;
    static int nsheeps, nwolves;
    static char[][] backyard = new char[MAX][MAX];

    static class Cell {
        int r, c;

        public Cell(int _r, int _c) {
            this.r = _r;
            this.c = _c;
        }
    };

    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    public static void BFS(Cell s) {
        Queue<Cell> q = new LinkedList<>();
        q.add(s);

        int sheep = (backyard[s.r][s.c] == 'k' ? 1 : 0);
        int wolf = (backyard[s.r][s.c] == 'v' ? 1 : 0);

        boolean canEscape = false;
        backyard[s.r][s.c] = '#';

        while (!q.isEmpty()) {
            Cell u = q.poll();

            for (int i = 0; i < 4; i++) {
                int r = u.r + dr[i];
                int c = u.c + dc[i];

                if (!isValid(r, c)) {
                    canEscape = true;
                    continue;
                }

                if (backyard[r][c] != '#') {
                    sheep += (backyard[r][c] == 'k' ? 1 : 0);
                    wolf += (backyard[r][c] == 'v' ? 1 : 0);
                    backyard[r][c] = '#';
                    q.add(new Cell(r, c));
                }
            }
        }

        if (canEscape) {
            nsheeps += sheep;
            nwolves += wolf;
        }
        else {
            if (sheep > wolf) {
                nsheeps += sheep;
            }
            else {
                nwolves += wolf;
            }
        }
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            backyard[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (backyard[i][j] != '#') {
                    BFS(new Cell(i, j));
                }
            }
        }

        System.out.print(nsheeps + " " + nwolves);
    }
}
