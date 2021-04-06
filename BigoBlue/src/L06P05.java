import java.util.*;
    /**
     * Tony Stark is on the mission to save the world from Loki's army so he spread N bombs in
     * the enemy region. He spread the bombs in such a way that a bomb can be in range of another
     * bomb i.e say bomb B1 is in range of bomb B2  , when bomb B2 explodes it will trigger bomb B1
     * and it also get explode but vice-versa might not be true because the bombs are of different of
     * range. As he is running out of energy so he left with one shot To trigger the bomb. Now he ask
     * Jarvis to find most appropriate bomb which he can trigger to make maximum impact.
     *
     * Impact is basically number of bombs get explode.
     *
     * Can you help Jarvis to do so?
     * A single line containing MAXIMUM IMPACT.
     *
     * Ex1
     *  input
     *  4 3
     *  1 2
     *  2 4
     *  1 3
     *  output
     *  4
     * Ex2
     *  input
     *  4 3
     *  1 2
     *  2 1
     *  2 3
     *  output
     *  3
     *  */

public class L06P05 {
    static final int MAX = 10005;
    static int N, M;
    static ArrayList<Integer> graph[] = new ArrayList[MAX];

    public static int DFS(int src) {
        boolean[] visited = new boolean[N + 1];
        Stack<Integer> s = new Stack<>();
        visited[src] = true;
        s.add(src);

        int nbombs = 0;

        while (!s.isEmpty()) {
            int u = s.pop();
            nbombs++;

            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    s.add(v);
                }
            }
        }

        return nbombs;
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < MAX; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
        }

        int max_bombs = 0;

        for (int i = 1; i <= N; i++) {
            max_bombs = Math.max(max_bombs, DFS(i));
        }

        System.out.print(max_bombs);
    }
}
