import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
