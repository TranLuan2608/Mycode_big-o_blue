import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
    /**
     *
     * In this problem you have to simulate the workflow of one-thread server.
     * There are nn queries to process, the i-th will be received at moment _i
     * and needs to be processed for d_i units of time. All t_i  are guaranteed to be distinct.
     * When a query appears server may react in three possible ways:
     * If server is free and query queue is empty, then server immediately starts to process this query.
     * If server is busy and there are less than b queries in the queue, then new query is added to the end of the queue.
     * If server is busy and there are already b queries pending in the queue, then new query is just rejected and will never be processed
     * As soon as server finished to process some query, it picks new one from the queue
     * (if it's not empty, of course). If a new query comes at some moment x, and the server
     * finishes to process another query at exactly the same moment, we consider that first
     * query is picked from the queue and only then new query appears.
     *
     * For each query find the moment when the server will finish to process it or print −1 if this query will be rejected.
     * Ex1
     *  input
     *  5 1
     *  2 9
     *  4 8
     *  10 9
     *  15 2
     *  19 1
     *  output
     *  11 19 -1 21 22
     *  */
public class L04P07 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int t, d;
        int n = sc.nextInt(), b = sc.nextInt();
        Queue<Long> q = new LinkedList<>();
        long processing = 0;
 
        for (int i = 0; i < n; i++) {
            t = sc.nextInt();
            d = sc.nextInt();
 
            while (!q.isEmpty() && q.peek() <= t) {
                q.remove();
            }
 
            if (q.size() <= b) {
                processing = Math.max(processing, t) + d;
                System.out.format("%d ", processing);
                q.add(processing);
            }
            else {
                System.out.println("-1 ");
            }
        }
    }
}
