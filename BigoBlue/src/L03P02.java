import java.util.Arrays;
import java.util.Scanner;
    /**
     * Petya and Vasya are brothers. Today is a special day for them as their parents left them
     * home alone and commissioned them to do n chores. Each chore is characterized by a single
     * parameter — its complexity. The complexity of the i -th chore equals H_i
     * As Petya is older, he wants to take the chores with complexity larger than some value x (h_i>x)
     * to leave to Vasya the chores with complexity less than or equal to  x(h_i <= x)
     * The brothers have already decided that Petya will do exactly a chores and Vasya will do exactly b chores (a + b = n)
     * In how many ways can they choose an integer x so that Petya got exactly a chores and Vasya got exactly b chores?
     * Ex1
     *  input
     *  7 3 4
     *  1 1 9 1 1 1 1
     *  output
     *  0
     * Ex2
     *  input
     *  5 2 3
     *  6 2 3 100 1
     *  output
     *  3*/

public class L03P02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), 
        a = sc.nextInt(), 
        b = sc.nextInt();
        int[] h = new int[n];

        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        Arrays.sort(h);
        System.out.println(h[b] - h[b - 1]);
    }
}
