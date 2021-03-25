import java.util.ArrayList;
import java.util.Scanner;
    /**
     * Alice and Bob like games. And now they are ready to start a new game.
     * They have placed n chocolate bars in a line. Alice starts to eat chocolate
     * bars one by one from left to right, and Bob — from right to left. For each
     * chocololate bar the time, needed for the player to consume it, is known
     * (Alice and Bob eat them with equal speed). When the player consumes a chocolate bar,
     * he immediately starts with another. It is not allowed to eat two chocolate bars at
     * the same time, to leave the bar unfinished and to make pauses. If both players start
     * to eat the same bar simultaneously, Bob leaves it to Alice as a true gentleman.
     * How many bars each of the players will consume?
     * Ex
     *  input
     *  5
     *  2 9 8 2 7
     *  output
     *  2 3
     *  */

public class L02P08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> chocolate = new ArrayList<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            chocolate.add(sc.nextInt());
        }

        int t_alice = 0, t_bob = 0;
        int i = 0, j = n - 1;

        while (i <= j) {
            if (t_alice + chocolate.get(i) <= t_bob + chocolate.get(j)) {
                t_alice += chocolate.get(i);
                i++;
            }
            else {
                t_bob += chocolate.get(j);
                j--;
            }
        }

        System.out.println(i + " " + (n - i));
    }
}
