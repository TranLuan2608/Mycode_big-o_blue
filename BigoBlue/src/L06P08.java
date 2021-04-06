import java.util.*;
    /**
     * Another chapter of the municipal chronicles of a well-known unbelievable lordly major town
     * (if this town is not well-known to you, you might want to solve problem CSTREET first) tells
     * us the following story:
     *
     * Once upon a time the citizens of the unbelievable lordly major town decided to elect a major.
     * At that time this was a very new idea and election campaigns were completely unknown. But of
     * course, several citizens wanted to become major and it didn't take long for them to find out,
     * that promising nice things that never will become real tends to be useful in such a situation.
     * One candidate to be elected as a major was Ivo sometimes called the benefactor because of his
     * valuable gifts to the unbelievably lordly major towns citizens.
     *
     * One day before the election day Ivo the benefactor made a promise to the citizens of the town.
     * In case of his victory in the elections he would ensure that on one of the paved streets of the
     * town street lamps would be erected and that he would pay that with his own money. As thrifty as
     * the citizens of the unbelievable lordly major town were, they elected him and one day after the
     * elections they presented him their decision which street should have street lamps. Of course,
     * they chose not only the longest of all streets but renamed several streets so that a very long
     * street in the town existed.
     *
     * Can you find how long this street was? To be more specific, the situation is as follows. You
     * are presented a list of all paved streets in the unbelievable lordly major town. As you might
     * remember from problem CSTREET in the town the streets are paved in a way that between every two
     * points of interest in the town exactly one paved connection exists. Your task is to find the
     * longest distance that exists between any two places of interest in the city.
     *
     *  For each testcase output one line which contains the maximum length of the longest street in the city.
     * Ex
     *  input
     *  1
     *  6
     *  1 2 3
     *  2 3 4
     *  2 6 2
     *  6 4 6
     *  6 5 5
     *  output
     *  12
     *
     *
     *  */
public class L06P08 {
    static final int MAX = 50000 + 5;
    static int V, E, leaf;
    static long max_dist;
    static long[] dist = new long[MAX];

    static class Triad {
        int v, w;

        public Triad(int _v, int _w) {
            this.v = _v;
            this.w = _w;
        }
    };

    static ArrayList<Triad> graph[] = new ArrayList[MAX];

    public static void DFS(int src) {
        for (int i = 0; i <= V; i++) {
            dist[i] = -1;
        }

        Stack<Integer> s = new Stack<>();
        s.add(src);
        dist[src] = 0;

        while (!s.isEmpty()) {
            int u = s.pop();

            for (Triad neighbor : graph[u]) {
                int v = neighbor.v;
                int w = neighbor.w;

                if (dist[v] == -1) {
                    dist[v] = dist[u] + w;
                    s.add(v);

                    if (dist[v] > max_dist) {
                        max_dist = dist[v];
                        leaf = v;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            V = sc.nextInt();
            E = V - 1;

            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<Triad>();
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                graph[u].add(new Triad(v, w));
                graph[v].add(new Triad(u, w));
            }

            max_dist = 0;

            DFS(1);
            DFS(leaf);

            System.out.println(max_dist);
        }
    }
}
