import java.util.*;
    /**
     * Yup!! The problem name reflects your task; just add a set of numbers. But you may feel yourselves
     * condescended, to write a C/C++ program just to add a set of numbers. Such a problem will simply
     * question your erudition. So, lets add some flavor of ingenuity to it. Addition operation requires
     * cost now, and the cost is the summation of those two to be added. So, to add 1 and 10,
     * you need a cost of 1. If you want to add 1,2 and 3. There are several ways
     *
     * 1	2	3
     * 1 + 2 = 3, cost = 3	1 + 3 = 4, cost = 4	2 + 3 = 5, cost = 5
     * 3 + 3 = 6, cost = 6	2 + 4 = 6, cost = 6	1 + 5 = 6, cost = 6
     * Total = 9	Total = 10	Total = 11
     *
     * I hope you have understood already your mission, to add a set of integers so that the cost is minimal.
     *
     * For each case print the minimum total cost of addition in a single line.
     *
     * Ex
     *  input
     *  3
     *  1 2 3
     *  4
     *  1 2 3 4
     *  0
     *  output
     *  9
     *  19
     *
     * */

public class L07P03 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (true) {
            int n = sc.nextInt();

            if (n == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                pq.add(x);
            }

            long ans = 0;

            while (pq.size() > 1) {
                int a = pq.poll();
                int b = pq.poll();
                ans += a + b;
                pq.add(a + b);
            }

            System.out.println(ans);
            pq.remove();
        }
    }
}
