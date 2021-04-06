import java.util.*;
    /**
     *
     * This question is designed to help you get a better understanding of basic heap operations.
     * You will be given queries of 3 types:
     *
     * "1v" - Add an element to the heap.
     * "2v" - Delete the element from the heap.
     * "3" - Print the minimum of all the elements in the heap.
     *
     * NOTE: It is guaranteed that the element to be deleted will be there in the heap. Also, at any
     * instant, only distinct elements will be in the heap.
     * For each query of type 3, print the minimum value on a single line.
     *
     * Ex
     *  input
     *  5
     *  1 4
     *  1 9
     *  3
     *  2 4
     *  3
     *  output
     *  4
     *  9
     *
     * */

public class L07P02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(), pqRemove = new PriorityQueue<>();

        int type, value;

        for (int k = 0; k < Q; k++) {
            type = sc.nextInt();

            if (type == 1) {
                value = sc.nextInt();
                pq.add(value);
            }
            else if (type == 2) {
                value = sc.nextInt();
                pqRemove.add(value);
            }
            else {
                while (!pqRemove.isEmpty() && (int)pq.peek() == (int)pqRemove.peek()) {
                    pq.remove();
                    pqRemove.remove();
                }

                System.out.println(pq.peek());
            }
        }
    }
}
