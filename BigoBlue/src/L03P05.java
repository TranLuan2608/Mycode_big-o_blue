import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
	/**
	 * Pasha decided to invite his friends to a tea party. For that occasion,
	 * he has a large teapot with the capacity of ww milliliters and 2n tea cups,
	 * each cup is for one of Pasha's friends. The i-th cup can hold at most a_i  milliliters of water.
	 * It turned out that among Pasha's friends there are exactly n boys and exactly n girls and all of
	 * them are going to come to the tea party. To please everyone, Pasha decided to pour the water for the tea as follows:
	 * 		Pasha can boil the teapot exactly once by pouring there at most ww milliliters of water;
	 * 		Pasha pours the same amount of water to each girl;
	 * 		Pasha pours the same amount of water to each boy;
	 * 		if each girl gets xx milliliters of water, then each boy gets 2x milliliters of water.
	 * 	In the other words, each boy should get two times more water than each girl does.
	 *
	 * Pasha is very kind and polite, so he wants to maximize the total amount of the water that
	 * he pours to his friends. Your task is to help him and determine the optimum distribution of '
	 * cups between Pasha's friends.
	 * Ex1
	 * 	input
	 * 	2 4
	 * 	1 1 1 1
	 * 	output
	 * 	3
	 * Ex2
	 * 	input
	 * 	3 18
	 * 	4 4 4 2 2 2
	 * 	output
	 * 	18
	 * 	*/
public class L03P05 {
    public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), w = sc.nextInt();
		ArrayList<Integer> cups = new ArrayList<>();
		
		for (int i = 0; i < n * 2; i++) {
			cups.add(sc.nextInt());
		}
		
		Collections.sort(cups);
		
		double m = Math.min(1.0 * cups.get(0), 1.0 * cups.get(n) / 2);
		double max_amount = 3 * m * n;
		System.out.println(Math.min(max_amount, w));
	}
}
