import java.util.Scanner;

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
