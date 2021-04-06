
import java.util.*;
/**
 * Kefa decided to celebrate his first big salary by going to the restaurant.
 *
 * He lives by an unusual park. The park is a rooted tree consisting of N vertices with the root
 * at vertex 1. Vertex 1 also contains Kefa's house. Unfortunaely for our hero, the park also
 * contains cats. Kefa has already found out what are the vertices with cats in them.
 *
 * The leaf vertices of the park contain restaurants. Kefa wants to choose a restaurant where he will
 * go, but unfortunately he is very afraid of cats, so there is no way he will go to the restaurant
 * if the path from the restaurant to his house contains more than M consecutive vertices with cats.
 *
 * Your task is to help Kefa count the number of restaurants where he can go.
 * Ex
 *  input
 *  4 1
 *  1 1 0 0
 *  1 2
 *  1 3
 *  1 4
 *  output
 *  2
 * Ex2
 *  input
 *  7 1
 *  1 0 1 1 0 0 0
 *  1 2
 *  1 3
 *  2 4
 *  2 5
 *  3 6
 *  3 7
 *  output
 *  2
 *  */
public class L05P05 {
    static final int MAX = 100000 + 5;
    static int n, m;
    static int[] a = new int[MAX];
    static int[] cat = new int[MAX];
    static boolean[] visited = new boolean[MAX];
    static ArrayList<Integer> graph[] = new ArrayList[MAX];

    public static int BFS(int s) {
        int restaurants = 0;
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        cat[s] = (a[s] == 1 ? 1 : 0);

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;

                    if (a[v] == 1) {
                        cat[v] = cat[u] + 1;
                    }

                    if (cat[v] <= m) {
                        if (graph[v].size() == 1) {
                            restaurants++;
                        }
                        else {
                            q.add(v);
                        }
                    }
                }
            }
        }

        return restaurants;
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        System.out.print(BFS(1));
    }
}
