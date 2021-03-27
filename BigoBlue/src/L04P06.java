import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
    /**
     * Before bridges were common, ferries were used to transport cars across rivers. River ferries,
     * unlike their larger cousins, run on a guide line and are powered by the river’s current.
     * Cars drive onto the ferry from one end, the ferry crosses the river, and the cars exit
     * from the other end of the ferry.
     *
     * There is a ferry across the river that can take N cars across the river in T minutes and
     * return in T minutes. A car may arrive at either river bank to be transported by the ferry
     * to the opposite bank. The ferry travels continuously back and forth between the banks so
     * long it is carrying a car or there is at least one car waiting at either bank. Whenever
     * the ferry arrives at one of the banks, it unloads its cargo and loads up to N cars that
     * are waiting to cross. If there are more than N, those that have been waiting the longest
     * are loaded. If there are no cars waiting on either bank, the ferry waits until one arrives,
     * loads it (if it arrives on the same bank of the ferry), and crosses the river. At what time
     * does each car reach the other side of the river?
     * Ex1
     *  input
     *  2
     *  2 10 10
     *  0 left
     *  10 left
     *  20 left
     *  30 left
     *  40 left
     *  50 left
     *  60 left
     *  70 left
     *  80 left
     *  90 left
     *  2 10 3
     *  10 right
     *  25 left
     *  40 left
     *  output
     *  10
     *  30
     *  30
     *  50
     *  50
     *  70
     *  70
     *  90
     *  90
     *  110
     *
     *  30
     *  40
     *  60
     *  */
public class L04P06 {
    static final int MAX = 10000 + 5;
    static class Car {
        int id, arriveTime;
         
        public Car(int _id, int _arriveTime) {
            this.id = _id;
            this.arriveTime = _arriveTime;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        int res[] = new int[MAX];
         
        while (Q-- > 0) {
            Queue<Car> qSide[] = new Queue[2];
            qSide[0] = new LinkedList<>();
            qSide[1] = new LinkedList<>();
             
            int n = sc.nextInt();
            int t = sc.nextInt();
            int m = sc.nextInt();
             
            for (int i = 1; i <= m; i++) {
                int arrived = sc.nextInt();
                String atBank = sc.next();
                 
                if (atBank.equals("left")) {
                    qSide[0].add(new Car(i, arrived));
                }
                else {
                    qSide[1].add(new Car(i, arrived));
                }
            }
             
            int curSide = 0, curTime = 0, nextTime;
            int waiting = (!qSide[0].isEmpty() ? 1 : 0) + (!qSide[1].isEmpty() ? 1 : 0);
             
            while (waiting > 0) {
                if (waiting == 1) {
                    nextTime = (qSide[0].isEmpty() ? qSide[1].peek().arriveTime : qSide[0].peek().arriveTime);
                }
                else {
                    nextTime = Math.min(qSide[0].peek().arriveTime, qSide[1].peek().arriveTime);
                }
                 
                curTime = Math.max(curTime, nextTime);
                int carried = 0;
                 
                while (!qSide[curSide].isEmpty()) {
                    Car car = qSide[curSide].peek();
                    if (car.arriveTime <= curTime && carried < n) {
                        res[car.id] = curTime + t;
                        carried++;
                        qSide[curSide].remove();
                    }
                    else {
                        break;
                    }
                }
                 
                curTime += t;
                curSide = 1 - curSide;
                waiting = (!qSide[0].isEmpty() ? 1 : 0) + (!qSide[1].isEmpty() ? 1 : 0);
            }
             
            for (int i = 1; i <= m; i++) {
                System.out.println(res[i]);
            }
                 
            if (Q > 0) {
                System.out.println();
            }
        }
    }
}
