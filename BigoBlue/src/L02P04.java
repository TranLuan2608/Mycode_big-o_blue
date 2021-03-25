import java.util.ArrayList;
import java.util.Scanner;
    /**
     *
     * You've got an array AA, consisting of NN integers: A1, A2, ..... An.
     * Your task is to find a minimal by inclusion segment [L,R](1<=L<=R<=N)
     * such, that among numbers A_L, A_L + 1,..... A_R  there are exactly K distinct numbers.
     * Segment [L,N] (1<=L<=R<=N; L, R are integer) of length M = R - L + 1,
     * satisfying the given property, is called minimal by inclusion, if there is no segment [X, Y]
     *  satisfying the property and less then MM in length, such that 1<=L<=X<=Y<=R<=N
     *  Note that the segment [L,R] doesn't have to be minimal in length among all segments, satisfying the given property
     *  Ex1
     *      input
     *      8 3
     *      1 1 2 2 3 3 4 5
     *      output
     *      2 5
     *  Ex2
     *      input
     *      7 4
     *      4 7 7 4 7 4 7
     *      output
     *      -1 -1
     * */
public class L02P04 {
    static final int MAX = (int)1e5 + 5;
    static int fre[] = new int[MAX];
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
         
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
         
        int unique = 0;
        int j = 0;
 
        for (int i = 0; i < n; i++) {
            if (fre[a.get(i)] == 0) {
                unique++;
            }
 
            fre[a.get(i)]++;
             
            while (unique == k) {
                fre[a.get(j)]--;
 
                if (fre[a.get(j)] == 0) {
                    System.out.printf("%d %d", j + 1, i + 1); 
                    return;
                }
 
                j++;
            }
        }
 
        System.out.println("-1 -1");
    }
}
