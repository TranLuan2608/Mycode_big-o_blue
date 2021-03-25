import java.util.Arrays;
import java.util.Scanner;
    /**
     * Vitaly is a diligent student who never missed a lesson in his five years of studying in the
     * university. He always does his homework on time and passes his exams in time.
     *
     * During the last lesson the teacher has provided two strings S and T to Vitaly.
     * The strings have the same length, they consist of lowercase English letters, string S
     * is lexicographically smaller than string T. Vitaly wondered if there is such string
     * that is lexicographically larger than string SS and at the same is lexicographically
     * smaller than string T. This string should also consist of lowercase English letters
     * and have the length equal to the lengths of strings SS and T.
     *
     * Let's help Vitaly solve this easy problem!
     * Ex1
     * input k m
     * output l
     * Ex2
     * input abcde abcdf
     * output No such string
     * */
public class L01P04 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        char a[] = sc.next().toCharArray();
        char b[] = sc.next().toCharArray();
 
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 'z') {
                a[i] = 'a';
            }
            else {
                a[i]++;
                break;
            }
        }
 
        System.out.println(Arrays.equals(a, b) ? "No such string".toCharArray() : a);
    } 
}
