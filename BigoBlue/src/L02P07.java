import java.util.ArrayList;
import java.util.Scanner;
    /**
     * Hands that shed innocent blood! There are n guilty people in a line, the i-th of them holds a claw with length L_i
     * The bell rings and every person kills some of people in front of him. All people kill others at the same time.
     * Namely, the i-th person kills the jj-th person if and only if j < i and j>=i - L_i You are given lengths of the
     * claws. You need to find the total number of alive people after the bell rings.
     * Ex1
     *  input
     *  4
     *  0 1 0 10
     *  output
     *  1
     * Ex2
     *  input
     *  10
     *  1 1 3 0 0 0 2 1 0 3
     *  output
     *  3
     *  */
public class L02P07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        int count = 0, j = n - 1, last_kill_pos = 0;

        for (int i = n - 1; i >= 0; i--) {
            j = Math.min(j, i);
            last_kill_pos = Math.max(0, i - a.get(i));

            if (j > last_kill_pos) {
                count += (j - last_kill_pos);
                j = last_kill_pos;
            }
        }

        System.out.println(n - count);
    }
}
