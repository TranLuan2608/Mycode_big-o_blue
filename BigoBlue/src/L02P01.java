import java.util.ArrayList;
import java.util.Scanner;

public class L02P01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
 
        int j = 0, max_books = 0, read_books = 0; 
         
        for (int i = 0; i < n; i++) { 
            a.add(sc.nextInt());
 
            while (t < a.get(i)) { 
                t += a.get(j);
                j++;
                read_books--;
            }
 
            t -= a.get(i);
            read_books++;
            max_books = Math.max(max_books, read_books);
        }
 
        System.out.println(max_books);
    }
}
