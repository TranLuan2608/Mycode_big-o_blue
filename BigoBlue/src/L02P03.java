import java.util.ArrayList;
import java.util.Scanner;
   /**
    * George decided to prepare a Codesecrof round, so he has prepared M problems for the round.
    * Let's number the problems with integers L through M. George estimates the i-th problem's
    * complexity by integer Bi
    * To make the round good, he needs to put at least NN problems there. Besides,
    * he needs to have at least one problem with complexity exactly A1 at least one with complexity exactly A2, ...,
    * and at least one with complexity exactly A_n. Of course, the round can also have problems with other complexities.
    * George has a poor imagination. It's easier for him to make some already prepared problem simpler than
    * to come up with a new one and prepare it. George is magnificent at simplifying problems. He can
    * simplify any already prepared problem with complexity C to any positive integer complexity D(C>=D)
    * , by changing limits on the input data.
    * However, nothing is so simple. George understood that even if he simplifies some problems, he can
    * run out of problems for a good round. That's why he decided to find out the minimum number of
    * problems he needs to come up with in addition to the M he's prepared in order to make a good
    * round. Note that George can come up with a new problem of any complexity.
    * Ex1
    *    input
    *    3 5
    *    1 2 3
    *    1 2 2 3 3
    *    output
    *    0
    * Ex2
    *    input
    *    3 5
    *    1 2 3
    *    1 1 1 1 1
    *    output
    *    2*/
public class L02P03 {
    static class Vest {
        int u, v;
        public Vest(int x , int y) {
           u = x;
           v = y; 
        }
     }
  
     public static void main (String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt(); 
        int m = sc.nextInt(); 
        int x = sc.nextInt(); 
        int y = sc.nextInt(); 
  
        ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();
  
        for (int i = 0; i < n; i++) {
           a.add(sc.nextInt());
        }
  
        for (int i = 0; i < m; i++) {
           b.add(sc.nextInt()); 
        }
  
        ArrayList<Vest> v = new ArrayList<>();  
  
        int i = 0, j = 0;
        while (i < n && j < m) {
           if (a.get(i) - x <= b.get(j) && b.get(j) <= a.get(i) + y) {
              v.add(new Vest(i + 1, j + 1));
              i++;
              j++;
           }
           else if (a.get(i) + y < b.get(j)) {
              i++;
           }
           else if (a.get(i) - x > b.get(j)) {
              j++;
           }
        }
  
        System.out.println(v.size()); 
  
        for (Vest vest : v) {
           System.out.println(vest.u + " " + vest.v);
        }
     }
}
