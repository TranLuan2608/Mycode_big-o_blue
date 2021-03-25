import java.util.ArrayList;
import java.util.Scanner;
    /**You are given two arrays A and B consisting of integers,
     *  sorted in non-decreasing order. Check whether it is possible to choose
     *  KK numbers in array AA and choose MM numbers in array BB so that any number
     *  chosen in the first array is strictly less than any number chosen in the second array
     *  Ex1
     *      input
     *      3 3
     *      2 1
     *      1 2 3
     *     3 4 5
     *      output
     *      Yes
     *  Ex2
     *      input
     *      3 3
     *      3 3
     *      1 2 3
     *      3 4 5
     *      output
     *      NO
     *      */
public class L01P05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aa = sc.nextInt();
        int bb = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
 
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
         
        for (int i = 0; i < aa; i++) 
            a.add(sc.nextInt());
             
        for (int i = 0; i < bb; i++)
            b.add(sc.nextInt());
         
        System.out.println(a.get(k - 1) < b.get(bb - m) ? "YES" : "NO");
    } 
}
