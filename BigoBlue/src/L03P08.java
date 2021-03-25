import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
    /**
     * Gerald is very particular to eight point sets. He thinks that any decent eight point set must
     * consist of all pairwise intersections of three distinct integer vertical straight lines and
     * three distinct integer horizontal straight lines, except for the average of these nine points.
     * In other words, there must be three integers x1, x2, x3 and three more integers y1, y2, y3 such that
     * x1<x2<x3, y1<y2<y3 and the eight point set consists of all points (xi, yj)(1<=i,j<=3) except for point (x2, y2)
     * You have a set of eight points. Find out if Gerald can use this set?
     * Ex1
     *  input
     *  0 0
     *  0 1
     *  0 2
     *  1 0
     *  1 2
     *  2 0
     *  2 1
     *  2 2
     *  output
     *  respectable
     * Ex2
     *  input
     *  0 0
     *  1 0
     *  2 0
     *  3 0
     *  4 0
     *  5 0
     *  6 0
     *  7 0
     *  output
     *  ugly
     *  */
public class L03P08 {
    static final int MAX = (int)1e6 + 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<>();
        ArrayList<Integer> unique_x = new ArrayList<>(), unique_y = new ArrayList<>();
        boolean[] fre_x = new boolean[MAX], fre_y = new boolean[MAX]; 

        for (int i = 0; i < 8; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            points.add(new Point(x, y));

            if (!fre_x[x]) {
                fre_x[x] = true;
                unique_x.add(x);
            }

            if (!fre_y[y]) {
                fre_y[y] = true;
                unique_y.add(y);
            }
        }

        if (unique_x.size() != 3 || unique_y.size() != 3) {
            System.out.println("ugly");
            return;
        }

        Collections.sort(unique_x);
        Collections.sort(unique_y);
        Collections.sort(points);
        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && i == 1) {
                    continue;
                }

                int x = points.get(index).x;
                int y = points.get(index).y;
                if (unique_x.get(i) == x && unique_y.get(j) == y) {
                    index++;
                }
                else {
                    System.out.println("ugly");
                    return;
                }
            }
        }

        System.out.println("respectable");
    }
}

class Point implements Comparable<Point> {
    Integer x, y;

    public Point(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }
    
    @Override
    public int compareTo(Point another) {
        if (this.x.equals(another.x)) {
            return this.y.compareTo(another.y);
        }
        return this.x.compareTo(another.x);
    }
}
