import java.util.*;

    /**
     * Roy is trying to develop a widget that shows Trending Topics (similar to Facebook) on the home
     * page of HackerEarth Academy. He has gathered a list of NN Topics (their IDs) and their popularity
     * score (say z-score) from the database. Now z-score change everyday according to the
     * following rules:
     *
     * When a topic is mentioned in a 'Post', its z-score is increased by 50.
     * A 'Like' on such a Post, increases the z-score by 5.
     * A 'Comment' increases z-score by 10.
     * A 'Share' causes an increment of 20.
     * Now the Trending Topics are decided according to the change in z-score.
     * One with the highest increment comes on top and list follows.
     *
     * Roy seeks your help to write an algorithm to find the top 5 Trending Topics.
     *
     * If change in z-score for any two topics is same, then rank them according to their ID
     * (one with higher ID gets priority). It is guaranteed that IDs will be unique.
     *
     * Print top 5 Topics each in a new line. Each line should contain two space separated
     * integers, Topic ID and new z-score of the topic.
     *
     *
     * Ex
     *  input
     *  8
     *  1003 100 4 0 0 0
     *  1002 200 6 0 0 0
     *  1001 300 8 0 0 0
     *  1004 100 3 0 0 0
     *  1005 200 3 0 0 0
     *  1006 300 5 0 0 0
     *  1007 100 3 0 0 0
     *  999 100 4 0 0 0
     *  output
     *  1003 200
     *  1002 300
     *  1001 400
     *  999 200
     *  1007 150
     *
     *  */

public class L07P04 {
    static class Topic {
        int id;
        long old_score, new_score, change;

        public Topic(int _id, long _old_score, long _new_score) {
            id = _id;
            old_score = _old_score;
            new_score = _new_score;
            change = new_score - old_score;
        }
    };

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Topic> pq = new PriorityQueue<>(new Comparator<Topic>() {
            public int compare(Topic a, Topic b) {
                if (a.change < b.change || (a.change == b.change && a.id < b.id)) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });

        for (int k = 0; k < n; k++) {
            int id = sc.nextInt();
            long old_score = sc.nextLong();
            long post = sc.nextLong(),          like = sc.nextLong();
            long comment = sc.nextLong(),       share = sc.nextLong();
            long new_score = post * 50 + like * 5 + comment * 10 + share * 20;
            pq.add(new Topic(id, old_score, new_score));
        }

        for (int i = 0; i < 5; i++) {
            Topic t = pq.poll();
            System.out.println(t.id + " " + t.new_score);
        }
    }
}
