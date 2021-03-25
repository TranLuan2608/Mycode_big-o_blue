import java.util.ArrayList;
import java.util.Scanner;
    /**
     * When Valera has got some free time, he goes to the library to read some books.
     * Today he's got T free minutes to read. That's why Valera took NN books in the
     * library and for each book he estimated the time he is going to need to read it.
     * Let's number the books by integers from L to N. Valera needs Ai minutes to read the i-th book.
     * Valera decided to choose an arbitrary book with number i and read the books one by one,
     * starting from this book. In other words, he will first read book number i, then book
     * number i + 1, then book number i + 2 and so on. He continues the process until
     * he either runs out of the free time or finishes reading the N-th book. Valera reads
     * each book up to the end, that is, he doesn't start reading the book if he doesn't
     * have enough free time to finish reading it.
     * Print the maximum number of books Valera can read.
     * Ex1
     *  input
     *  4 5
     *  3 1 2 1
     *  output
     *  3
     * Ex2
     *  input
     *  3 3
     *  2 2 3
     *  output
     *  1
     *  */

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
