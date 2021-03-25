import java.util.Arrays;
    import java.util.Scanner;
    /**
     * Being a programmer, you like arrays a lot. For your birthday, your friends
     * have given you an array a consisting of n distinct integers.
     * Unfortunately, the size of aa is too small. You want a bigger array!
     * Your friends agree to give you a bigger array, but only if you are able to
     * answer the following question correctly: is it possible to sort the array a
     * (in increasing order) by reversing exactly one segment of a? See definitions of segment and reversing in the notes.
     * Note
     * A segment [l,r] of array a is the sequence a_l, a_l+1, ..... a_r
     * If you have an array a of size n and you reverse its segment [l,r], the array will become:
     * a_1,a_2,....a_l-2, a_l-1, a_r, a_r-1, ... a_l+1, a_l,a_r, a_r+1,... a_n-1, a_n.
     * Ex1
     *  input
     *  3
     *  3 2 1
     *  output
     *  yes
     *  1 3
     * Ex2
     *  input
     *  4
     *  3 1 2 4
     *  output
     *  no
     *  */
public class L03P03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n], sorted_a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sorted_a[i] = a[i];
        }

        Arrays.sort(sorted_a);
        int l = 0, r = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] != sorted_a[i]) {
                l = i;
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (a[i] != sorted_a[i]) {
                r = i;
                break;
            }
        }

        for (int i = l, j = r; i < j; i++, j--) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        if (!Arrays.equals(a, sorted_a)) {
            System.out.println("no");
            return;
        }

        System.out.println("yes");
        System.out.println((l + 1) + " " + (r + 1));
    }
}
