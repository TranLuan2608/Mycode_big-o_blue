import java.util.Scanner;
import java.util.Stack;

public class L04P01 {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for(int i=0; i<n; i++)
    {
        String ex = sc.next();
        transfrom(ex);
    } 
}
private static void transfrom(String ex) {
    Stack<Character> s = new Stack<>();
    for(int i=0; i<ex.length(); i++)
    {
        char symbol = ex.charAt(i);
        if(Character.isLetter(symbol))
        {
            System.out.print(symbol);
        }else if( symbol == ')')
        {
            System.out.print(s.pop());
        }else if( symbol != '(')
        {
            s.push(symbol);
        }
    }
    System.out.println();
}

}
