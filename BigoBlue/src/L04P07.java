import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class L04P07 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int t, d;
        int n = sc.nextInt(), b = sc.nextInt();
        Queue<Long> q = new LinkedList<>();
        long processing = 0;
 
        for (int i = 0; i < n; i++) {
            t = sc.nextInt();
            d = sc.nextInt();
 
            while (!q.isEmpty() && q.peek() <= t) {
                q.remove();
            }
 
            if (q.size() <= b) {
                processing = Math.max(processing, t) + d;
                System.out.format("%d ", processing);
                q.add(processing);
            }
            else {
                System.out.println("-1 ");
            }
        }
    }
}
