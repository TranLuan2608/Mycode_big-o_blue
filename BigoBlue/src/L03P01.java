import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
	/**
	 *
	 * Devu is a dumb guy, his learning curve is very slow. You are supposed to teach him nn subjects, the i-th
	 * subject has C_i chapters. When you teach him, you are supposed to teach all the chapters of a subject continuously.
	 * Let us say that his initial per chapter learning power of a subject is x hours. In other words
	 * he can learn a chapter of a particular subject in xx hours.
	 *
	 * Well Devu is not complete dumb, there is a good thing about him too. If you teach him a subject,
	 * then time required to teach any chapter of the next subject will require exactly 11 hour less than
	 * previously required (see the examples to understand it more clearly). Note that his per chapter
	 * learning power can not be less than 11 hour.
	 *
	 * You can teach him the nn subjects in any possible order. Find out minimum amount of time (in hours)
	 * Devu will take to understand all the subjects and you will be free to do some enjoying task rather than teaching a dumb guy.
	 *
	 * Please be careful that answer might not fit in 3232 bit data type.
	 * Ex1
	 * 	input
	 * 	2 3
	 * 	4 1
	 * 	output
	 * 	11
	 * 	*/
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
