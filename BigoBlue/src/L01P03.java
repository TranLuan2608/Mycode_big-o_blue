import java.util.ArrayList;
import java.util.Scanner;
public class L01P03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (time + 15 < a.get(i)) {
                System.out.print(time + 15);
                return;
            }
            else {
                time = a.get(i);
            }
        }
        System.out.println(Math.min(time + 15, 90));
    }   
}