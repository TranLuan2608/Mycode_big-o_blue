import java.util.Arrays;
import java.util.Scanner;

public class L01P04 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        char a[] = sc.next().toCharArray();
        char b[] = sc.next().toCharArray();
 
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 'z') {
                a[i] = 'a';
            }
            else {
                a[i]++;
                break;
            }
        }
 
        System.out.println(Arrays.equals(a, b) ? "No such string".toCharArray() : a);
    } 
}
