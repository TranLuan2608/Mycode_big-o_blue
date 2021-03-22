import java.util.Arrays;
import java.util.Scanner;

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
