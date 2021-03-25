import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class L07P01 {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());
        int n = sc.nextInt();
        for(int i=0; i<n; i++)
        {
            maxHeap.add(sc.nextInt());
            if(maxHeap.size()==1 || maxHeap.size()==2)
            {
                System.out.println("-1");
            }else
            {

            }


        }



    }

    static class MaxHeapComparator implements Comparator<Integer>
    {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }
}
