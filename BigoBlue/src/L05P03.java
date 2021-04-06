import java.util.*;
    /**
     * Samarpit is the main hero of the Dhoom 4. He is trying to steal from the Code Bank Of Hackers.
     * Samarpit has a key with an integer value printed on it. He also has N other keys with each key
     * having its own specific value.Samarpit is trying to break the Lock for which he is supposed to
     * get to the lock's key value. He can perform one type of operation. Take his own key and one of
     * the other N keys and merge them. During merging Samarpit's Key value changes to product of both
     * the keys modulus 100000.
     * For example if his key value was X and he took a key with value Y the his new key will be
     * (X⋅Y)%100000. The other key that was used during the merging process
     * remains along with other N - 1 keys.
     * This entire process of merging takes 1 second. Now since he is in a hurry he asks to you to
     * find the minimum time in which he could reach to the lock's key value.
     * Ex
     *  input
     *  3 30
     *  3
     *  2 5 7
     *  output
     *  2
     *  */
public class L05P03 {
        static final int MAX = 100000 + 5;
        static final int MOD = 100000;
        static int N;
        static int[] dist = new int[MAX];
        static int[] a = new int[MAX];

        public static int BFS(int s, int f) {
            Arrays.fill(dist, -1);
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            dist[s] = 0;
            while (!q.isEmpty()) {
                int u = q.poll();

                for (int i = 0; i < N; i++) {
                    Long temp = (1L * a[i] * u) % MOD;
                    int v = temp.intValue();

                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        q.add(v);

                        if (v == f) {
                            return dist[v];
                        }
                    }
                }
            }

            return -1;
        }

        public static void main(String[] agrs) {
            Scanner sc = new Scanner(System.in);
            int s = sc.nextInt();
            int f = sc.nextInt();
            N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }

            System.out.print(BFS(s, f));
        }
}
