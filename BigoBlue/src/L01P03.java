import java.util.ArrayList;
import java.util.Scanner;
/**
 * Bear Limak likes watching sports on TV. He is going to watch a game today. The game lasts 9090 minutes and there are no breaks.
 *
 * Each minute can be either interesting or boring. If 1515 consecutive minutes are boring then Limak immediately turns TV off.
 * ou know that there will be NN interesting minutes T1, T2, T3.....Tn .Your task is to calculate for how many minutes Limak will watch the game.
 * Ex
 * input
 * 3
 * 7 20 88
 * output
 * 35
 * */
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