import java.util.ArrayList;
import java.util.Scanner;

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
