import java.util.ArrayList;
import java.util.Scanner;
    /**
     * When Xellos was doing a practice course in university, he once had to measure the intensity
     * of an effect that slowly approached equilibrium. A good way to determine the equilibrium
     * intensity would be choosing a sufficiently large number of consecutive data points that
     * seems as constant as possible and taking their average. Of course, with the usual sizes
     * of data, it's nothing challenging — but why not make a similar programming contest problem while we're at it?
     * You're given a sequence of N data points A1 ..... An There aren't any big jumps between consecutive data
     * points — for each 1<=i<=N it's guaranteed that | A_i+1 - A_i | <=1
     * A range [L, R] of data points is said to be almost constant if the difference between
     * the largest and the smallest value in that range is at most 11. Formally, let MM be the
     * maximum and m the minimum value of A_i for L<=i<=R , the range [L,R] is almost constant if M - m <=1
     * Find the length of the longest almost constant range.
     * Ex1
     *  input
     *  5
     *  1 2 3 3 2
     *  output
     *  4
     * Ex2
     *  input
     *  11
     *  5 4 5 5 6 7 8 8 8 7 6
     *  output
     *  5
     *  */
public class L02P06 {
    static final int MAX = (int)1e5 + 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<>();
        int n = sc.nextInt();
 
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
 
        int[] fre = new int[MAX];
        int j = 0, diff = 0;
        int longest_range = 0;
        
        for (int i = 0; i < n; i++) {
            if (fre[a.get(i)] == 0) {
                diff++;
            }
            fre[a.get(i)]++;
 
            while (j < n && diff > 2) {
                if (fre[a.get(j)] == 1) {
                    diff--;
                }
                fre[a.get(j)]--;
                j++;
            }
 
            longest_range = Math.max(longest_range, i - j + 1);
        }
 
        System.out.println(longest_range);
    }
}
