import java.util.*;

    /**
     * A large Bytelandian supermarket chain has asked you to write a program for the simulating costs
     * of a promotion being prepared.
     *
     * The promotion has to follow the following rules:
     *
     *      A customer who wants to participate in the promotion, writes on the receipt, paid by himself,
     * his personal details and throws it into a special ballot box.
     *      At the end of every day of the promotion, two bills are taken out from the ballot box:
     * First, the receipt amounting to the largest sum is chosen,
     * Then the receipt amounting to the smallest sum is chosen;
     *      The customer who has paid the largest sum gets a money prize equal to the difference between
     * the sum on his bill and the sum on the bill amounting to the smallest sum.
     *      To avoid multiple prizes for one purchase, both bills selected according to the above rules
     * are not returned to the ballot box, but all remaining bills still participate in the promotion.
     * The turnover of the supermarket is very big, thus an assumption can be made, that at the end of
     * every day, before taking out receipts amounting to the largest and the smallest sum, there are
     * at least 2 receipts in the ballot box.
     * Your task is to compute (on the basis of information about prices on receipts thrown into the
     * ballot box on each day of promotion) what the total cost of prizes during the whole promotion will be.
     *
     * Write a program, which: reads from the standard input a list of prices on receipts thrown into
     * the ballot box on each day of the promotion, computes the total cost of prizes paid in consecutive
     * days of promotion, then writes the result to the standard output.
     *The output should contain exactly one integer, equal to the total cost of prizes paid during the whole promotion.
     *
     * Ex
     *  input
     *  5
     *  3 1 2 3
     *  2 1 1
     *  4 10 5 5 1
     *  0
     *  1 2
     *  output
     *  19
     * */

public class L07P05 {
    static final int MAX = (int)1e6 + 5;

    static class Bill {
        int number, price;

        public Bill(int _number, int _price) {
            this.number = _number;
            this.price = _price;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] taken = new boolean[MAX];
        int n = sc.nextInt();
        int nbills = 0;
        long money = 0;

        PriorityQueue<Bill> maxHeap = new PriorityQueue<>(new Comparator<Bill>() {
            public int compare(Bill a, Bill b) {
                return b.price - a.price;
            }
        });

        PriorityQueue<Bill> minHeap = new PriorityQueue<>(new Comparator<Bill>() {
            public int compare(Bill a, Bill b) {
                return a.price - b.price;
            }
        });

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                nbills++;

                maxHeap.add(new Bill(nbills, x));
                minHeap.add(new Bill(nbills, x));
            }

            while (taken[maxHeap.peek().number]) {
                maxHeap.remove();
            }

            while (taken[minHeap.peek().number]) {
                minHeap.remove();
            }

            taken[maxHeap.peek().number] = taken[minHeap.peek().number] = true;
            money += maxHeap.poll().price - minHeap.poll().price;
        }

        System.out.print(money);
    }
}
