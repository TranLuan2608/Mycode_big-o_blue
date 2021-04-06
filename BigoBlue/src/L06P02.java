import java.util.*;
import java.io.*;
    /**
     * Well, the annual technical symposium of Department of Computer Technology is around the corner.
     * All that we need, to make it a grand success is Publicity among the peer groups (Of course the
     * sponsors too). We decided to share the job between the student groups. As per the plan we
     * decided to meet people in person and influence them to attend Prayatna. But to meet them we
     * have to go to various student groups. To do so, we had to cut our classes. But being studious,
     * the students refused to cut more classes. Instead of meeting every one in person we decided to
     * meet few people such that the person to whom we pass the news will spread it to all his friends.
     * And those friends will pass it to other friends and so on. Your task is to find the number of
     * people to be met by the organizers to spread the news.
     * Output contains T line, the number of people, the organizers have to meet in person for each test case.
     * Ex
     *  input
     *  2
     *  4
     *  2
     *  0 1
     *  1 2
     *  3
     *  0
     *  output
     *  2
     *  3
     *  */
public class L06P02 {
    static final int MAX = 100000 + 5;
    static int V, E;
    static boolean[] visited = new boolean[MAX];
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
                    s.add(v);
                }
            }
        }
    }

    public static void main(String[] agrs) {
        MyScanner in = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int Q = in.nextInt();

        while (Q-- > 0) {
            V = in.nextInt();
            E = in.nextInt();

            for (int i = 0; i < V; i++) {
                visited[i] = false;
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }

            int count = 0;

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    count++;
                    DFS(i);
                }
            }

            out.println(count);
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
