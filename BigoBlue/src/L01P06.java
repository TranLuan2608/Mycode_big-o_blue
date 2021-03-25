import java.util.ArrayList;
import java.util.Scanner;
    /**
     * A coordinate line has NN segments, the ii-th segment starts at the position Li and ends at the position Ri
     * We will denote such a segment as [Li,Ri]
     * You have suggested that one of the defined segments covers all others. In other words,
     * there is such segment in the given set, which contains all other ones. Now you want to
     * est your assumption. Find in the given set the segment which covers all other segments,
     * and print its number. If such a segment doesn't exist, print -1
     * Formally we will assume that segment [a,b]  covers segment [c,d] if they meet this condition
     * a<=c<=d<=b
     * Ex1
     *  input
     *  3
     *  3 3
     *  4 4
     *  5 5
     *  output
     *  -1
     * Ex1
     *  input
     *  6
     *  1 5
     *  2 3
     *  1 10
     *  7 10
     *  7 7
     *  10 10
     *  output
     *  3
     *  */
public class L01P06 {
    static final int INF = (int)1e9 + 5;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> L = new ArrayList<>(), R = new ArrayList<>();
 
        int left = INF, right = 0;   
         
        for (int i = 0; i < n; i++) {
            L.add(sc.nextInt());
            R.add(sc.nextInt());
            left = Math.min(left, L.get(i));
            right = Math.max(right, R.get(i));
        }
 
        for (int i = 0; i < n; i++) {
            if (left == L.get(i) && right == R.get(i)) {
                System.out.print(i + 1);
                return;
            }
        }
 
        System.out.println(-1);
    }
}
