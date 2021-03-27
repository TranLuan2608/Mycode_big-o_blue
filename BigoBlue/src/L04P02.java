import java.util.Scanner;
import java.util.Stack;
    /**
     * For sure, the love mobiles will roll again on this summer's street parade. Each year,
     * the organisers decide on a fixed order for the decorated trucks. Experience taught them
     * to keep free a side street to be able to bring the trucks into order.
     *
     * The side street is so narrow that no two cars can pass each other. Thus, the love mobile
     * that enters the side street last must necessarily leave the side street first. Because the
     * trucks and the ravers move up closely, a truck cannot drive back and re-enter the side street
     * or the approach street.
     *
     * You are given the order in which the love mobiles arrive. Write a program that decides if
     * the love mobiles can be brought into the order that the organisers want them to be.
     * Ex1
     *  input
     *  5
     *  5 1 2 4 3
     *  0
     *  output
     *  yes
     *  */
public class L04P02 {
    static final int MAX = 1005;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] trucks = new int[MAX];
        Stack<Integer> side_trucks = new Stack<>();
         
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
 
            for (int i = 0; i < n; i++) {
                trucks[i] = sc.nextInt();
            }
 
            int ordering = 1;
            int i = 0;
 
            while (i < n) {
                if (trucks[i] == ordering) {
                    ordering++;
                    i++;
                }
                else if (!side_trucks.empty() && side_trucks.peek().equals(ordering)) {
                    ordering++;
                    side_trucks.pop();
                }
                else {
                    side_trucks.push(trucks[i]);
                    i++;
                }
            }
 
            while (!side_trucks.empty() && side_trucks.peek().equals(ordering)) {
                ordering++;
                side_trucks.pop();
            }
 
            System.out.println(ordering == n + 1 ? "yes" : "no");
            side_trucks.clear();
        }
    }
}
