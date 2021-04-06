
import java.util.*;
    /**
     * The Monk learned about priority queues recently and asked his teacher for an interesting problem.
     * So his teacher came up with a simple problem. He now has an integer array A. For each index i,
     * he wants to find the product of the largest, second largest and the third largest integer in the
     * range [1,i]. Note: Two numbers can be the same value-wise but they should be distinct index-wise.
     * Print the answer for each index in each line. If there is no second largest or third largest number
     * in the array A upto that index, then print "-1", without the quotes.
     * Ex
     *  input'
     *  5
     *  1 2 3 4 5
     *  output
     *  -1
     *  -1
     *  6
     *  24
     *  60
     *
     *  */
public class L07P01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            pq.add(-x);

            if (i < 2) {
                System.out.println(-1);
            }
            else {
                int first = -pq.poll();
                int second = -pq.poll();
                int third = -pq.poll();

                System.out.println(1L * first * second * third);

                pq.add(-first);
                pq.add(-second);
                pq.add(-third);
            }
        }
    }
}
