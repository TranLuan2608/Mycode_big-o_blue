import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
    /**
     * Your government has finally solved the problem of universal health care! Now everyone,
     * rich or poor, will finally have access to the same level of medical care. Hurrah!
     *
     * There’s one minor complication. All of the country’s hospitals have been condensed down
     * into one location, which can only take care of one person at a time. But don’t worry!
     * There is also a plan in place for a fair, efficient computerized system to determine who
     * will be admitted. You are in charge of programming this system.
     *
     * Every citizen in the nation will be assigned a unique number, from 1 to P (where P is
     * the current population). They will be put into a queue, with 1 in front of 2, 2 in front
     * of 3, and so on. The hospital will process patients one by one, in order, from this queue.
     * Once a citizen has been admitted, they will immediately move from the front of the queue to the back.
     *
     * Of course, sometimes emergencies arise; if you’ve just been run over by a steamroller, you
     * can’t wait for half the country to get a routine checkup before you can be treated! So, for
     * these (hopefully rare) occasions, an expedite command can be given to move one person to the
     * front of the queue. Everyone else’s relative order will remain unchanged.
     * Ex1
     *  input
     *  3 6
     *  N
     *  N
     *  E 1
     *  N
     *  N
     *  N
     *  10 2
     *  N
     *  N
     *  0 0
     *  output
     *  Case 1:
     *  1
     *  2
     *  1
     *  3
     *  2
     *  Case 2:
     *  1
     *  2
     *  */
public class L04P04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P, C, n, x, temp, tc = 1;
        char cmd;
        Queue<Integer> q = new LinkedList<Integer>();
 
        while (true) {
            P = sc.nextInt();
            C = sc.nextInt(); 
             
            if (P == 0 && C == 0) {
                break;
            }
 
            for (int i = 1; i <= Math.min(P, C); i++) {
                q.add(i);
            }
 
            System.out.format("Case %d:\n", tc++);
             
            for (int i = 0; i < C; i++) {
                cmd = sc.next().charAt(0);
                 
                if (cmd == 'N') {
                    System.out.println(q.peek());
                    q.add(q.poll());
                }
                else {
                    x = sc.nextInt();
                    n = q.size();
                    q.add(x);
 
                    for (int j = 0; j < n; j++) {
                        temp = q.poll();
                        if (temp != x) {
                            q.add(temp);
                        }
                    }
                }
            }
 
            while (!q.isEmpty()) {
                q.remove();
            }
        }
    }
}
