import java.util.Scanner;
import java.util.Stack;
    /**
     * A molecule can be defined as a sequence of atoms and represented by a chemical formula
     * consisting of letters denoting these atoms. E.g. letter H denotes atom of hydrogen,
     * C denotes atom of carbon, O denotes atom of oxygen, formula COOH represents molecule
     * consisting of one atom of carbon, two atoms of oxygen and one atom of hydrogen.
     *
     * To write some formulas efficiently, we use the following rules. Letters denoting some
     * atoms can be grouped by enclosing in parentheses, e.g. formula CH(OH) contains group
     * OH. Groups can be nested – a group can also contain other groups. To simplify a formula,
     * consecutive occurrences of the same letter can be replaced with that letter followed by a
     * number of these occurrences. E.g. formula COOHHH can be written as CO22H33 and it represents
     * a molecule consisting of one atom of carbon, two atoms of oxygen and three atoms of hydrogen.
     * Furthermore, consecutive occurrences of the same group can be replaced with that group followed
     * by a number of these occurrences. E.g. formula CH(CO2H) (CO2H) (CO2H) can be written
     * as CH(CO2H)3 and molecule represented by both those formulas consists of four atoms
     * of carbon, four atoms of hydrogen and six atoms of oxygen. A number written after a letter
     * or a group is always greater than or equal to 2 and less than or equal to 9. A mass of a
     * molecule is a sum of masses of all its atoms. One atom of hydrogen has mass 1, one atom of
     * carbon has mass 12 and one atom of oxygen has mass  16.
     * Write a program that will calculate a mass of a molecule.
     * Ex1
     *  input
     *  COOH
     *  output
     *  45
     * Ex2
     *  input
     *  ((CH)2(OH2H)(C(H))O)3
     *  output
     *  222
     *  */
public class L04P05 {
    public static int mass(char c) {
        return c == 'H' ? 1 : (c == 'C' ? 12 : 16);
    }
 
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        String s;
        s = sc.next();
 
        Stack<Integer> atom = new Stack<>();
        int w, mol;
 
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                atom.add(mass(c));
            }
            else if (Character.isDigit(c)) {
                mol = atom.peek() * (c - '0');
                atom.pop();
                atom.add(mol);
            }
            else if (c == '(') {
                atom.add(-1);
            }
            else if (c == ')') {
                w = 0;
                while (atom.peek() != -1) {
                    w += atom.peek();
                    atom.pop();
                }
                atom.pop();
                atom.add(w);
            }
        }
 
        int sum = 0;
        while (!atom.isEmpty()) {
            sum += atom.peek();
            atom.pop();
        }
 
        System.out.println(sum);
    }
}
