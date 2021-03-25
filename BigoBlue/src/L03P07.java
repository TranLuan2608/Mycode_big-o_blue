import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
    /**
     *
     * What joy! Petya's parents went on a business trip for the whole year and the playful kid is
     * left all by himself. Petya got absolutely happy. He jumped on the bed and threw pillows all
     * day long, until..
     *
     * Today Petya opened the cupboard and found a scary note there. His parents had left him with
     * duties: he should water their favourite flower all year, each day, in the morning, in the
     * afternoon and in the evening. "Wait a second!" — thought Petya. He know for a fact that if
     * he fulfills the parents' task in the i-th (1<=i<=12)  month of the year, then the flower will grow by a_i
     * centimeters, and if he doesn't water the flower in the i-th month, then the flower won't grow this month.
     * Petya also knows that try as he might, his parents won't believe that he has been watering the
     * flower if it grows strictly less than by k centimeters.
     * Help Petya choose the minimum number of months when he will water the flower, given that the
     * flower should grow no less than by k centimeters.
     * Ex1
     *  input
     *  5
     *  1 1 1 1 2 2 3 2 2 1 1 1
     *  output
     *  2
     * Ex2
     *  input
     *  0
     *  0 0 0 0 0 0 0 1 1 2 3 0
     *  output
     *  0
     *  */
public class L03P07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            a.add(sc.nextInt());
        }

        Collections.sort(a, Collections.reverseOrder());
        int n_months = 0;
        
        for (int height : a) {
            if (k <= 0) {
                break;
            }

            n_months++;
            k -= height;
        }

        System.out.println(k <= 0 ? n_months : -1);
    }
}
