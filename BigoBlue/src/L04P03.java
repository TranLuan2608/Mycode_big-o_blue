import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
    /**
     * Given is an ordered deck of N cards numbered 1 to N with card 1 at the top
     * and card N at the bottom. The following operation is performed as long as there are
     * at least two cards in the deck:
     *
     * Throw away the top card and move the card that is now on the top of
     * the deck to the bottom of the deck.
     *
     * Your task is to find the sequence of discarded cards and the last, remaining card.
     *
     * Ex1
     *  input
     *  7
     *  19
     *  10
     *  6
     *  0
     *  output
     *  Discarded cards: 1, 3, 5, 7, 4, 2
     *  Remaining card: 6
     *  Discarded cards: 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 4, 8, 12, 16, 2, 10, 18, 14
     *  Remaining card: 6
     *  Discarded cards: 1, 3, 5, 7, 9, 2, 6, 10, 8
     *  Remaining card: 4
     *  Discarded cards: 1, 3, 5, 2, 6
     *  Remaining card: 4
     *  */
public class L04P03 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> deck = new LinkedList<>();
        ArrayList<Integer> discarded_cards = new ArrayList<>();
         
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
 
            for (int i = 1; i <= n; i++) {
                deck.add(i);
            }
 
            while (deck.size() >= 2) {
                discarded_cards.add(deck.poll());
                deck.add(deck.poll());
            }
 
            System.out.print("Discarded cards:");
            for (int i = 0; i < n - 1; i++) {
                if (i != 0) {
                    System.out.print(",");
                }
                System.out.format(" %d", discarded_cards.get(i));
            }
            System.out.println();
            System.out.format("Remaining card: %d\n", deck.poll());
 
            discarded_cards.clear();
        }
    }
}
