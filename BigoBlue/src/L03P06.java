import java.util.Arrays;
import java.util.Scanner;
    /**
     * Little Vasya has received a young builder’s kit. The kit consists of several wooden bars,
     * the lengths of all of them are known. The bars can be put one on the top of the other if their lengths are the same.
     *
     * Vasya wants to construct the minimal number of towers from the bars. Help Vasya to use the
     * bars in the best way possible.
     *
     * Ex1
     *  input
     *  3
     *  1 2 3
     *  output
     *  1 3
     * Ex2
     *  input
     *  4
     *  6 5 6 7
     *  output
     *  2 3
     *  */
public class L03P06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bars = new int[n];

        for (int i = 0; i < n; i++) {
            bars[i] = sc.nextInt();
        }

        Arrays.sort(bars);
        int n_towers = 1, max_height = 1, cur_height = 1;

        for (int i = 1; i < n; i++) {
            if (bars[i] == bars[i - 1]) {
                cur_height++;
                max_height = Math.max(max_height, cur_height);
            }
            else {
                n_towers++;
                cur_height = 1;
            }
        }

        System.out.println(max_height + " " + n_towers);
    }
}
