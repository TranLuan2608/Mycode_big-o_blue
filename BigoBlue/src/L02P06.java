import java.util.ArrayList;
import java.util.Scanner;

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
