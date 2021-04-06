import java.util.*;
import java.io.*;
    /**
     * Chef has opened up a new restaurant. Like every other restaurant, critics critique this place.
     * The Chef wants to gather as much positive publicity as he can. Also, he is very aware of the
     * fact that people generally do not tend to go through all the reviews. So he picks out the positive
     * reviews and posts it on the website of the restaurant. A review is represented by an integer which
     * is the overall rating of the restaurant as calculated by that particular review. A review is
     * considered to be positive if it is among the top one-third of the total reviews when they are
     * sorted by their rating. For example, suppose the ratings given by 88 different reviews are as follows:
     *
     * 2 8 3 1 6 4 5 7
     *
     * Then the top one-third reviews will be 8 and 7. Note that we considered one-third to be 8/3=2 top reviews according to integer division. (see Notes)
     *
     * So here is what the Chef wants from you: Given the reviews(ratings) by different critics, the Chef
     * needs you to tell him what is the minimum rating that his website will be displaying. For example
     * in the above case, the minimum rating that will be displayed is 7. Also, different critics keep
     * reviewing the restaurant continuosly. So the new reviews keep coming in. The Chef wants your website
     * ratings to be up-to-date. So you should keep updating the ratings there. At any point of time, the
     * Chef might want to know the minimum rating being displayed. You'll have to answer that query. An
     * interesting thing to note here is that a review might be in the website for some time and get
     * knocked out later because of new better reviews and vice-versa.
     *
     * Notes: To be precise, the number of reviews displayed website will be floor(n/3), where n
     * denotes the current number of all reviews.
     *
     * For every test case, output a single integer each for every operation of type 2 mentioned above.
     * If no review qualifies as a positive review, print "No reviews yet".
     *
     *
     * Ex
     *  input
     *  10
     *  1 1
     *  1 7
     *  2
     *  1 9
     *  1 21
     *  1 8
     *  1 5
     *  2
     *  1 9
     *  2
     *  output
     *  No reviews yet
     *  9
     *  9
     *  */

public class L07P06 {

    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);
        PriorityQueue<Integer> top3 = new PriorityQueue<>();
        PriorityQueue<Integer> rest = new PriorityQueue<>();
        int n = in.nextInt();
        int nreviews = 0;

        while (n-- > 0) {
            int type = in.nextInt();

            if (type == 1) {
                int x = in.nextInt();
                nreviews++;

                if (!top3.isEmpty() && top3.peek() < x) {
                    rest.add(-top3.poll());
                    top3.add(x);
                }
                else {
                    rest.add(-x);
                }

                if (nreviews % 3 == 0) {
                    top3.add(-rest.poll());
                }
            }
            else {
                if (top3.isEmpty()) {
                    out.println("No reviews yet");
                }
                else {
                    out.println(top3.peek());
                }
            }
        }
        out.close();
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st = null;
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public MyScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        boolean hasNext() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String tmp = br.readLine();
                    if (tmp == null)
                        return false;
                    st = new StringTokenizer(tmp);
                } catch (IOException e) {
                    return false;
                }
            }
            return true;
        }
        String next() {
            if (hasNext())
                return st.nextToken();
            return null;
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
