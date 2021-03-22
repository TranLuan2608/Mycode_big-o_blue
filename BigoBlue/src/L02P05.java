import java.util.ArrayList;
import java.util.Scanner;

public class L02P05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> cards = new ArrayList<>();
        int n = sc.nextInt();
 
        for (int i = 0; i < n; i++) {
            cards.add(sc.nextInt());
        }
 
        int[] res = {0, 0};
        int player = 0;
        int i = 0, j = n - 1;
 
        while (i <= j) {
            if (cards.get(i) > cards.get(j)) {
                res[player] += cards.get(i);
                i++;
            }
            else {
                res[player] += cards.get(j);
                j--;
            }
 
            player = 1 - player;
        }
 
        System.out.println(res[0] + " " + res[1]);
    }
}
