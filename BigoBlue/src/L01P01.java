import java.util.ArrayList;
import java.util.Scanner;
    /**
     *     According to rules of the Berland fashion, a jacket should be fastened by all the buttons except
     *     only one, but not necessarily it should be the last one. Also if the jacket has only one button,
     *     it should be fastened, so the jacket will not swinging open.
     *     You are given a jacket with NN buttons. Determine if it is fastened in a right way.
     *     EX
     *         Input
     *         3
     *         1 0 0
     *         Output
     *         NO
    */
public class L01P01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int butjack = sc.nextInt();
        ArrayList<Integer> aList = new ArrayList<>();
        for(int i=0; i<butjack; i++)
        {
            int a = sc.nextInt();
            aList.add(i, a);
        }
        int count = 0;
        int value;
        if(butjack==1)
        {
            value = aList.get(0);
            if(value==1)
            {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }else{
            for(int i=0; i<butjack;i++)
            {
                value = aList.get(i);
                if(value==0)
                {
                    count++;
                }
            }
            if(count==1)
            {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }



}
