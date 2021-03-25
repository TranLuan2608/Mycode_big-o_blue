import java.util.Scanner;
    /**
     * Bizon the Champion isn't just a bison. He also is a favorite of the "Bizons" team.
     *
     * At a competition the "Bizons" got the following problem: "You are given two distinct
     * words (strings of English letters), ss and tt. You need to transform word ss into word tt".
     * The task looked simple to the guys because they know the suffix data structures well. Bizon
     * Senior loves suffix automaton. By applying it once to a string, he can remove from this string
     * any single character. Bizon Middle knows suffix array well. By applying it once to a string,
     * he can swap any two characters of this string. The guys do not know anything about the suffix
     * tree, but it can help them do much more.
     *
     * Bizon the Champion wonders whether the "Bizons" can solve the problem. Perhaps, the solution
     * do not require both data structures. Find out whether the guys can solve the problem and if
     * they can, how do they do it? Can they solve it either only with use of suffix automaton or
     * only with use of suffix array or they need both structures? Note that any structure may be
     * used an unlimited number of times, the structures may be used in any order
     * Ex1
     *  input
     *  automaton
     *  tomat
     *  output
     *  automaton
     * Ex2
     *  input
     *  need
     *  tree
     *  output
     *  need tree
     *
     * */
public class L01P08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        
        boolean need_tree = false, array = false, automaton = false;
        int[] sCount = new int[26];
        int[] tCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (tCount[i] > sCount[i]) {
                need_tree = true;
            }
            else if (tCount[i] < sCount[i]) {
                automaton = true;
            }
        }

        int index_found = 0, match = -1;

        for (int i = 0; i < t.length(); i++) {
            index_found = s.indexOf(t.charAt(i), match + 1);

            if (index_found > match) {
                match = index_found;
            }
            else {
                array = true;
                break;
            }
        }

        if (need_tree) {
            System.out.println("need tree");
        }
        else if (automaton && array) {
            System.out.println("both");
        }
        else if (automaton) {
            System.out.println("automaton");
        }
        else {
            System.out.println("array");
        }
    }
}
