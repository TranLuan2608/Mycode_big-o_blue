import java.util.*;
    /**
     * Dudu needs a document to finalize a task in his work. After searching, he found out that this
     * document needed other documents, which also needed other documents and so on.
     *
     * Dudu made a final list with the documents he will need. With that in hands, he suspects that
     * the list contains loops. For instance, if a document A depends on the document B that also
     * depends on A, it would make the task impossible to finish. In this case the loop contains only
     * two documents, but there might be cases with three or more!
     *
     * Given the list of the dependencies, help him compute if he can obtain all the documents, it
     * is, to compute if there isn't a loop in the given dependencies.
     *
     * For each case, print YES if there is at least one loop, and NO otherwise.
     *
     * Ex
     *  input
     *  3
     *  2 1
     *  1 2
     *  2 2
     *  1 2
     *  2 1
     *  4 4
     *  2 3
     *  3 4
     *  4 2
     *  1 3
     *  output
     *  NO
     *  YES
     *  YES
     *  */
public class L06P04 {
    static final int MAX = 10005;
    static int N, M;
    static int[] visited = new int[MAX];
    static ArrayList<Integer> graph[] = new ArrayList[MAX];

    public static boolean DFS(int u) {
        visited[u] = 1;

        for (int v : graph[u]) {
            if (visited[v] == 1) {
                return true;
            }
            else if (visited[v] == 0) {
                if (DFS(v)) {
                    return true;
                }
            }
        }

        visited[u] = 2;
        return false;
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            N = sc.nextInt();
            M = sc.nextInt();

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<Integer>();
                visited[i] = 0;
            }

            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
            }

            boolean isCyclic = false;

            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) {
                    isCyclic = DFS(i);
                    if (isCyclic) {
                        break;
                    }
                }
            }

            System.out.println(isCyclic ? "YES" : "NO");
        }
    }
}
