/*2.	Napisati program koji učitava dva prirodna broja M i N (ne staju obavezno u tip int ili long), 
a zatim štampa njihov zbir.
Na primjer:
ULAZ:						ULAZ:			
123456789123456789			89321809894321098894
111111111111111111			54892489123098089234
IZLAZ:						IZLAZ:	
234567900234567900			144214299017419188128
*/

import java.util.Scanner;
import java.util.Stack;

public class Zad2 {

    public static int[] Zbir2VelikaBroja (String broj1, String broj2) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        Stack<Integer> zbir = new Stack<>();

        int l1 = broj1.length();    //broj moramo da pretvorimo u niz cifara prvo???
        int l2 = broj2.length();

        for(int i = 0; i < l1; i++) {    //tek kada popujemo cifru saberemo je sa drugom cifrom
            stack1.push(broj1.charAt(i));   //daje nam karakter na poziciji i
        }
        for(int j = 0; j < l2; j++) {
            stack2.push(broj2.charAt(j));
        }

        int prenos = 0;
        int veciBrojDuzina = Math.max(l1, l2);
        for(int i = 0; i < veciBrojDuzina; i++) {    //pronadjemo maksimum od ta dva niza da bi znali koliko polja da sabiramo
            int cifra1, cifra2;
            if (!stack1.isEmpty())
                cifra1 = Character.getNumericValue(stack1.pop());   //uzima poslednju cifru prvog broja iz stacka
            else
                cifra1 = 0;
            if (!stack2.isEmpty())
                cifra2 = Character.getNumericValue(stack2.pop());
            else
                cifra2 = 0;

            int z = cifra1 + cifra2 + prenos;
            
            int ostatak = z % 10;   //racunamo ostatak
            zbir.push(ostatak);     //upisujemo ostatak

            prenos = z / 10;
        }

        if (prenos > 0) {
            zbir.push(prenos);
            veciBrojDuzina++;
        }

        //int n = l1 + l2;        //kao jer ne moze se preko toga prec, bitno je samo da ne damo premalo

        int rezultat[] = new int[veciBrojDuzina];

        int i = 0;
        while(!zbir.isEmpty()){
            int p = zbir.pop();
            rezultat[i] = p;
            i++;
        }

        return rezultat;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String broj1, broj2;
        broj1 = scanner.nextLine();
        broj2 = scanner.nextLine();


        int[] y = Zbir2VelikaBroja(broj1, broj2);
        for(int i = 0; i < y.length; i++) {
            System.out.print(y[i]);
        }
        System.out.println();
    }
}
