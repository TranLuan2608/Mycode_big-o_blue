import java.util.*;
/**
 * A maritime accident has caused oil to spill onto the seas of Felipistonia, which is a major natural
 * disaster. The Felipistonia's government wants to clean up this mess before more damage occurs.
 * To do this, they first have to know how serious was the accident and the amount of oil that has
 * been spilled into the sea. The only instrument the Felipistonia's government has to get information
 * of the magnitude of this disaster, is the use of satellite images. With these images they can
 * estimate how much money they have to spend to clean this mess. For this, the number of slicks
 * in the seas and the size of each slick must be know. A slick is a patch of oil floating on water.
 * Unfortunately, the Felipistonia's people are not very bright, so they have hired you to help them
 * process the image.
 * An example of an image obtained by the satellites is shown in Figure 1(a). This image can be
 * transformed to 0's and 1's as seen in Figure 1(b). Given this binary matrix, your job is to
 * count the number of slicks in the ocean and their corresponding size. Two adjacent pixels in
 * the image are considered to be in the same slick if they are in the same row or the same column.
 * For each image, output the number of slicks in the sea. Additionally, output the size of each slick
 * in ascending order and the number of slicks of that size.
 *
 * Ex
 *  input
 *  10 10
 *  1 1 1 1 1 1 1 1 1 1
 *  1 1 1 1 0 0 0 0 0 0
 *  1 1 1 0 0 0 0 1 1 1
 *  1 1 0 0 1 0 0 1 1 1
 *  1 0 1 0 0 1 1 0 0 0
 *  0 0 0 0 0 0 0 0 0 0
 *  0 0 0 0 0 0 0 0 0 0
 *  1 1 1 1 1 1 1 1 1 1
 *  0 0 0 0 0 0 0 0 0 0
 *  1 1 1 1 1 1 1 1 1 1
 *  0 0
 *  output
 *  7
 *  1 2
 *  2 1
 *  6 1
 *  10 2
 *  20 1
 *  */
public class L05P06 {
    static final int MAX = 251;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int N, M;
    static int[][] table = new int[MAX][MAX];
    static int[] slick = new int[MAX * MAX];

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
        table[s.r][s.c] = 0;
        int count = 1;

        while (!q.isEmpty()) {
            Cell u = q.poll();

            for (int i = 0; i < 4; i++) {
                int r = u.r + dr[i];
                int c = u.c + dc[i];

                if (isValid(r, c) && table[r][c] == 1) {
                    table[r][c] = 0;
                    q.add(new Cell(r, c));
                    count++;
                }
            }
        }

        slick[count]++;
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            N = sc.nextInt();
            M = sc.nextInt();

            if (N == 0 && M == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    table[i][j] = sc.nextInt();
                    slick[i * M + j + 1] = 0;
                }
            }

            int nslicks = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (table[i][j] == 1) {
                        nslicks++;
                        BFS(new Cell(i, j));
                    }
                }
            }

            System.out.println(nslicks);

            for (int i = 1; i <= N * M; i++) {
                if (slick[i] != 0) {
                    System.out.println(i + " " + slick[i]);
                }
            }
        }
    }
}
