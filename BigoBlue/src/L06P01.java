import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
    /**
     * There are N countries 1,2,3,4....N and N−1 roads(i.e depicting a tree)
     *
     * Bishu lives in the Country 1 so this can be considered as the root of the tree.
     *
     * Now there are Q girls who lives in various countries (not equal to 1) .
     *
     * All of them want to propose Bishu. But Bishu has some condition.
     *
     * He will accept the proposal of the girl who lives at minimum distance from his country.
     *
     * Now the distance between two countries is the number of roads between them.
     *
     * If two or more girls are at the same minimum distance then he will accept the proposal of the
     * girl who lives in a country with minimum id.
     *
     * No two girls are at same country.
     * Print the idid of the country of the girl who will be accepted.
     * Ex1
     *  input
     *  6
     *  1 2
     *  1 3
     *  1 4
     *  2 5
     *  2 6
     *  4
     *  5
     *  6
     *  3
     *  4
     *  output
     *  3
     *  */
public class L06P01 {

    static final int MAX = 1000 + 5;
    static int V, E;
    static boolean[] visited = new boolean[MAX];
    static int[] dist = new int[MAX];
    static ArrayList<Integer> graph[] = new ArrayList[MAX];

    public static void DFS(int scr) {
        Stack<Integer> s = new Stack<>();
        visited[scr] = true;
        s.add(scr);

        while (!s.isEmpty()) {
            int u = s.pop();

            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    s.add(v);
                }
            }
        }
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);;
        V = sc.nextInt();
        E = V - 1;

        for (int i = 0; i < MAX; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        DFS(1);
        int ans = 0;
        int min_dist = MAX;
        int Q = sc.nextInt();

        for (int i = 0; i < Q; i++) {
            int u = sc.nextInt();

            if (dist[u] < min_dist || (dist[u] == min_dist && u < ans)) {
                min_dist = dist[u];
                ans = u;
            }
        }

        System.out.print(ans);
    }
}
