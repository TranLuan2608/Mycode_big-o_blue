import java.util.ArrayList;
import java.util.Scanner;

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
