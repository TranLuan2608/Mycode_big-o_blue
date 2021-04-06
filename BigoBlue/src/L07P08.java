import java.util.*;
import java.io.*;
    /**
     *
     * A new web-design studio, called SMART (Simply Masters of ART), employs two people. The first
     * one is a web-designer and an executive director at the same time. The second one is a programmer.
     * The director is so a nimble guy that the studio has already got N contracts for web site development.
     * Each contract has a deadline d_i
     *
     * It is known that the programmer is lazy. Usually he does not work as fast as he could.
     * Therefore, under normal conditions the programmer needs b_i of time to perform the contract
     * number i. Fortunately, the guy is very greedy for money. If the director pays him x_i
     * dollars extra, he needs only (b_i - a_i * x_i) of time to do his job. But this extra payment does not
     * influence other contracts. This means that each contract should be paid separately to be
     * done faster. The programmer is so greedy that he can do his job almost instantly if the extra
     * payment is (b_i/a_i)dollars for the contract number i.
     * The director has a difficult problem to solve. He needs to organize programmer’s job and,
     * may be, assign extra payments for some of the contracts so that all contracts are performed
     * in time. Obviously he wishes to minimize the sum of extra payments. Help the director!
     *
     * For each testcase in the input your program should output one line with a single real number S.
     * Here S is the minimum sum of money which the director needs to pay extra so that the programmer
     * could perform all contracts in time. The number must have two digits after the decimal point.
     *
     * Ex
     *  input
     *  1
     *  2
     *  20 50 100
     *  10 100 50
     *  output
     *  5.00
     *  */


class Job implements Comparable<Job>{

    public int a,b,d;
    public int compareTo(Job j){
        return this.d - j.d;
    }
    Job(){
        a = b = d = 0;
    }
}
class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
class L07P08 {
    static final int MAX = 100005;
    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);

        int t,N;
        t = sc.nextInt();

        for(int k = 0 ; k < t; k++)
        {
            PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {

                @Override
                public int compare(Job o1, Job o2) {
                    return o2.a - o1.a;
                }
            });
            N = sc.nextInt();
            Job J[] = new Job[MAX];
            for(int i =0; i  < N; i++){
                J[i] = new Job();
                J[i].a = sc.nextInt();
                J[i].b = sc.nextInt();
                J[i].d = sc.nextInt();
            }
            Arrays.sort(J,0,N);
            double sum_min = 0;
            int time = 0 ;
            for(int i = 0; i < N;i++){
                time += J[i].b;
                pq.add(J[i]);
                while (time > J[i].d)
                {
                    Job top = pq.poll();
                    if (top.b > time - J[i].d)
                    {
                        sum_min += (time - J[i].d) * 1.0 / top.a;
                        top.b -= time - J[i].d;
                        pq.add(top);
                        time = J[i].d;
                    }
                    else
                    {
                        sum_min += top.b * 1.0 / top.a;
                        time -= top.b;
                        top.b = 0;
                    }
                }
            }
            System.out.printf("%.2f\n", sum_min);
        }
    }
}