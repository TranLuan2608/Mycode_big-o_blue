import java.util.Scanner;
import java.util.Stack;
    /**
     * Lira is now very keen on compiler development.
     *
     * She knows that one of the most important components of a compiler, is its parser.
     *
     * A parser is, in simple terms, a software component that processes text, and checks it's
     * semantic correctness, or, if you prefer, if the text is properly built.
     *
     * As an example, in declaring and initializing an integer, in C/C++, you can't do something like:
     * int = x;4
     * as the semantics of such statement is incorrect, as we all know that the datatype must
     * precede an identifier and only afterwards should come the equal sign and the initialization
     * value, so, the corrected statement should be: int x = 4;
     * Today, Lira is concerned with an abstract instruction which is composed of
     * the characters "<" and ">" , which she will use on the design of her language, L++.
     * She is using it as an abstraction for generating XML code Tags in an easier fashion
     * and she understood that, for an expression to be valid, a "<" symbol must always have a
     * corresponding ">" character somewhere (not necessary immediately) after it. Moreover,
     * each ">" symbol should correspond to exactly one "<" symbol.
     *
     * So, for instance, the instructions:
     * <<>>
     *
     * <>
     *
     * <><>
     *
     * are all valid. While:
     *
     * >>
     *
     * ><><
     *
     * are not.
     *
     * Given some expressions which represent some instructions to be analyzed by Lira's compiler,
     * you should tell the length of the longest prefix of each of these expressions that is valid,
     * or 0 if there's no such a prefix.
     * Ex
     *  input
     *  3
     *  <<>>
     *  ><
     *  <>>>
     *  output
     *  4
     *  0
     *  2
     *  */
public class L04P08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int k = 0; k < T; k++) {
            String s = sc.next();
            Stack<Character> expr = new Stack<>();
            int ans = 0;
 
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '<') {
                    expr.push(s.charAt(i));
                }
                else if (expr.empty()) {
                    break;
                }
                else {
                    expr.pop();
                    ans = (expr.empty() ? i + 1 : ans);
                }
            }
 
            System.out.println(ans);
        }
    }
}
