import java.util.*;

    /**
     * There is a bag-like data structure, supporting two operations:
     *
     * 1 x : Throw an element xx into the bag.
     * 2 : Take out an element from the bag.
     * Given a sequence of operations with return values, you’re going to guess the data structure.
     * It is a stack (Last-In, First-Out), a queue (First-In, First-Out), a priority-queue
     * (Always take out larger elements first) or something else that you can hardly imagine!
     *
     * For each test case, output one of the following:
     *
     * stack : It’s definitely a stack.
     * queue : It’s definitely a queue.
     * priority queue : It’s definitely a priority queue.
     * impossible : It can’t be a stack, a queue or a priority queue.
     * not sure : not sure It can be more than one of the three data structures mentioned above.
     *
     * Ex
     *  input
     *  6
     *  1 1
     *  1 2
     *  1 3
     *  2 1
     *  2 2
     *  2 3
     *  6
     *  1 1
     *  1 2
     *  1 3
     *  2 3
     *  2 2
     *  2 1
     *  2
     *  1 1
     *  2 2
     *  4
     *  1 2
     *  1 1
     *  2 1
     *  2 2
     *  7
     *  1 2
     *  1 5
     *  1 1
     *  1 3
     *  2 5
     *  1 4
     *  2 4
     *  output
     *  queue
     *  not sure
     *  impossible
     *  stack
     *  priority queue
     *
     *  */


public class L07P07 {
    static int isStack, isQueue, isPQ;
    static Stack<Integer> s = new Stack<>();
    static Queue<Integer> q = new LinkedList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            s.clear();
            q.clear();
            pq.clear();
            isStack = isQueue = isPQ = 1;

            for (int i = 0; i < n; i++) {
                int type = sc.nextInt();
                int x = sc.nextInt();

                if (type == 1) {
                    s.add(x);
                    q.add(x);
                    pq.add(-x);
                }
                else {
                    if (s.empty()) {
                        isStack = isQueue = isPQ = 0;
                        continue;
                    }

                    if (s.pop() != x) {
                        isStack = 0;
                    }
                    if (q.poll() != x) {
                        isQueue = 0;
                    }
                    if (pq.poll() != -x) {
                        isPQ = 0;
                    }
                }
            }

            if (isStack + isQueue + isPQ == 0) {
                System.out.println("impossible");
            }
            else if (isStack + isQueue + isPQ > 1) {
                System.out.println("not sure");
            }
            else if (isStack == 1) {
                System.out.println("stack");
            }
            else if (isQueue == 1) {
                System.out.println("queue");
            }
            else {
                System.out.println("priority queue");
            }
        }
    }
}
