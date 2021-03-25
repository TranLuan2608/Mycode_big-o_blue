import java.util.ArrayList;
import java.util.Scanner;
    /**
     * Sereja and Dima play a game. The rules of the game are very simple. The players have n
     * cards in a row. Each card contains a number, all numbers on the cards are distinct.
     * The players take turns, Sereja moves first. During his turn a player can take one card:
     * either the leftmost card in a row, or the rightmost one. The game ends when there is no
     * more cards. The player who has the maximum sum of numbers on his cards by the end of the game, wins.
     *
     * Sereja and Dima are being greedy. Each of them chooses the card with the larger number during his move.
     *
     * Inna is a friend of Sereja and Dima. She knows which strategy the guys are using, so she wants
     * to determine the final score, given the initial state of the game. Help her.
     * Ex1
     *  input
     *  4
     *  4 1 2 10
     *  output
     *  12 5
     * Ex2
     *  input
     *  7
     *  1 2 3 4 5 6 7
     *  output
     *  16 12
     *  */
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
