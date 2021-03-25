import java.util.Scanner;
    /**
     *Vanya is managed to enter his favourite site Codehorses.
     * Vanya uses nn distinct passwords for sites at all, however he can't
     * remember which one exactly he specified during Codehorses registration.
     *
     * Vanya will enter passwords in order of non-decreasing their lengths,
     * and he will enter passwords of same length in arbitrary order. Just
     * when Vanya will have entered the correct password, he is immediately
     * authorized on the site. Vanya will not enter any password twice.
     *
     * Entering any passwords takes one second for Vanya. But if Vanya will
     * enter wrong password kk times, then he is able to make the next try only 5
     * seconds after that. Vanya makes each try immediately, that is, at each moment
     * when Vanya is able to enter password, he is doing that.
     *
     * Determine how many seconds will Vanya need to enter Codehorses in the best
     * case for him (if he spends minimum possible number of second) and in the worst
     * case (if he spends maximum possible amount of seconds).
     *
     * Ex1
     *  input
     *  5 2
     *  cba
     *  abc
     *  bb1
     *  abC
     *  ABC
     *  abc
     *  output
     *  1 15
     * Ex2
     *  input
     *  4 100
     *  11
     *  22
     *  1
     *  2
     *  22
     *  output
     *  3 4
     *  */
public class L01P07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] cnt = new int[101];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            cnt[s.length()]++;
        }

        String password = sc.next();
        int best_time = 0, worst_time = 0;

        for (int i = 0; i < password.length(); i++) {
            best_time += cnt[i];
        }

        worst_time = best_time + cnt[password.length()] - 1;

        best_time += (best_time / k) * 5;
        worst_time += (worst_time / k) * 5;

        System.out.println((best_time + 1) + " " + (worst_time + 1));
    }
}
