import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
    /**
     * Professor GukiZ likes programming contests. He especially likes to rate his students on
     * the contests he prepares. Now, he has decided to prepare a new contest.
     *
     * In total, nn students will attend, and before the start, every one of them has some
     * positive integer rating. Students are indexed from 11 to nn. Let's denote the rating of i-th student as a_i
     * ​​ . After the contest ends, every student will end up with some positive integer position.
     * GukiZ expects that his students will take places according to their ratings.
     * He thinks that each student will take place equal to 1+ (number of student of strictly higher rating than his of her)
     * In particular, if student A has rating strictly
     * lower then student B, A will get the strictly better position than B, and if two students have equal
     * ratings, they will share the same position.
     *
     * GukiZ would like you to reconstruct the results by following his expectations.
     * Help him and determine the position after the end of the contest for each of his
     * students if everything goes as expected.
     * Ex1
     *  input
     *  3
     *  1 3 3
     *  output
     *  3 1 1
     * Ex2
     *  input
     *  5
     *  3 5 3 4 5
     *  output
     *  4 1 4 3 1*/
public class L03P04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ratings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ratings.add(sc.nextInt());
        }

        ArrayList<Integer> sorted_ratings = new ArrayList<>(ratings);
        Collections.sort(sorted_ratings, Collections.reverseOrder());
        int[] ranked = new int[2005];

        for (int i = 0; i < n; i++) {
            int rating = sorted_ratings.get(i);
            if (ranked[rating] == 0) {
                ranked[rating] = i + 1;
            }
        }

        for (int rating : ratings) {
            System.out.print(ranked[rating] + " ");
        }
    }
}
