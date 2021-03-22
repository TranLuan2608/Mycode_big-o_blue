import java.util.Scanner;

public class L01P02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        char a = 'a';
        int dist, count = 0;
 
        for (char c : n.toCharArray()) {
            dist = Math.abs(a - c);
            if (dist < 13) {
                count = count + dist;
            }
            else {
                count = count + (26 - dist);
            }
 
            a = c;
        }
 
        System.out.println(count);

    }
}
