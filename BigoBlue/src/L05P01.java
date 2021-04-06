import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
    /**
     * Consider an undirected graph consisting of N nodes where each node is labeled from 1 to
     * N and the edge between any two nodes is always of length 6. We define node SS to be the
     * starting position for a BFS.
     * Given Q queries in the form of a graph and some starting node, S, perform each query by
     * calculating the shortest distance from starting node S to all the other nodes in the graph.
     * Then print a single line of N - 1 space-separated integers listing node S is shortest
     * distance to each of the N - 1 other nodes (ordered sequentially by node number); if S is
     * disconnected from a node, print −1 as the distance to that node.
     * Ex1
     *  input
     *  2
     *  4 2
     *  1 2
     *  1 3
     *  1
     *  3 1
     *  2 3
     *  2
     *  output
     *  6 6 -1
     *  -1 6
     * */
public class L05P01 {
    static final int MAX = 1000 + 5;
    static int V, E;
    static boolean[] visited = new boolean[MAX];
    static int[] dist = new int[MAX];
    static ArrayList<Integer> graph[] = new ArrayList[MAX];
 
    public static void BFS(int s) {
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
 
        while (!q.isEmpty()) {
            int u = q.poll();
 
            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
    }
 
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
         
        for (int i = 0; i < MAX; i++) {
            graph[i] = new ArrayList<>();
        }
 
        while (Q-- > 0) {
            V = sc.nextInt();
            E = sc.nextInt();
 
            for (int i = 0; i < MAX; i++) {
                graph[i].clear();
                visited[i] = false;
                dist[i] = 0;
            }
 
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }
 
            int s = sc.nextInt();
            BFS(s);
 
            for (int i = 1; i <= V; i++) {
                if (i == s) {
                    continue;
                }
 
                System.out.print((visited[i] ? dist[i] * 6 : -1) + " ");
            }
 
            System.out.println();
        }
    }
}
