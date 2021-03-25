import java.util.Scanner;
/**
 * Grigoriy, like the hero of one famous comedy film, found a job as a night security guard at
 * the museum. At first night he received embosser and was to take stock of the whole exposition
 *
 * Embosser is a special devise that allows to "print" the text of a plastic tape.
 * Text is printed sequentially, character by character. The device consists of a wheel with a
 * lowercase English letters written in a circle, static pointer to the current letter and a button
 * that print the chosen letter. At one move it's allowed to rotate the alphabetic wheel one step clockwise or
 * counterclockwise. Initially, static pointer points to letter 'a'.Other letters are located as shown on the picture:
 *
 * After Grigoriy add new item to the base he has to print its name on the plastic tape and attach it to the corresponding
 * exhibit. It's not required to return the wheel to its initial position with pointer on the letter 'a'.
 * Our hero is afraid that some exhibits may become alive and start to attack him, so he wants to print the names as fast as possible.
 * Help him, for the given string find the minimum number of rotations of the wheel required to print it
 * EX1
 * Input
 * ares
 * Output
 * 34
 * Ex2
 * input
 * map
 * output
 * 35
 * */
public class L01P02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        char a = 'a';
        int dist, count = 0;
 
        for (char c : n.toCharArray()) {
            dist = Math.abs(a - c);
            if (dist < 13) {
                count = count + dist;
            }
            else {
                count = count + (26 - dist);
            }
 
            a = c;
        }
 
        System.out.println(count);

    }
}
