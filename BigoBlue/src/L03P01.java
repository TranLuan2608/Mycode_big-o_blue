import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class L03P01 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		ArrayList<Integer> c = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			c.add(sc.nextInt());
		}
		
		Collections.sort(c);
		
		long min_time = 0;
		
		for (int chapters : c) {
			min_time += 1L * chapters * x;
			if (x > 1) {
				x--;
			}
		}
		
		System.out.println(min_time);
	}

}
