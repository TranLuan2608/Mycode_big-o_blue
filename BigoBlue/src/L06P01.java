import java.util.ArrayList;
import java.util.Scanner;

public class L06P01 {

    static ArrayList<ArrayList<Integer>> graph;
    static int n;
    static ArrayList<Integer> path;
    static ArrayList<Boolean> visited;
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        n = sc.nextInt();
        graph = new ArrayList<>(n);
    }
}
