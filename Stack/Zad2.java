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

    public static int[] zbir2VelikaBroja (String broj1, String broj2) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        Stack<Integer> zbir = new Stack<>();

        int l1 = broj1.length();
        int l2 = broj2.length();

        for (int i = 0; i < l1; i++) {
            stack1.push(broj1.charAt(i));   //prvo pushujemo sve cifre prvog broja u stack1
        }
        for (int j = 0; j < l2; j++) {
            stack2.push(broj2.charAt(j));   //onda pushujemo sve cifre drugog broja u stack2
        }

        int prenos = 0;     //pamti prenos iz prethodnog sabiranja, zbog toga ide prije int z = cifra1 + cifra2 + prenos, na pocetku je 0 jer nista jos nismo sabrali
        int veciBrojDuzina = Math.max(l1, l2);  //pronadji veci broj od ta dva niza da bi znali koliko polja da ostavimo za zbir

        for(int i = 0; i < veciBrojDuzina; i++) {   //Petlja ide veciBrojDuzina puta — da obuhvati sve cifre oba broja.
            int cifra1, cifra2;

            if(!stack1.isEmpty()) {
                cifra1 = Character.getNumericValue(stack1.pop());   //char tip pretvaramo u int sa Character.getNumericValue()
            } else {
                cifra1 = 0; //ako je prazan stack1 onda je cifra1 = 0
            }

            if(!stack2.isEmpty()) {
                cifra2 = Character.getNumericValue(stack2.pop());
            } else {
                cifra2 = 0;
            }

            int z = cifra1 + cifra2 + prenos;

            int ostatak = z % 10;   //racunamo ostatak - tako uzimamo posljednju cifru iz broja z koji je zbir, ako je z=15, ostatak je 5 i njega pushujemo u zbir, a prenos je 1
            zbir.push(ostatak);     //upisujemo u stack ostatak

            prenos = z / 10;
        }

        if(prenos > 0) {        //npr ako se na kraju desi 999 + 1 = 1000, nakon poslednje cifre, može da ostane još jedan prenos koji treba dodati kao nova cifra
            zbir.push(prenos);  //Ako prenos postoji (veći od nule), guramo ga kao novu cifru na vrh zbir stacka.
            veciBrojDuzina++;   //Takođe povećavamo veciBrojDuzina jer je rezultat sad duži za 1 cifru.
        }

        int rezultat[] = new int[veciBrojDuzina];

        int i = 0;
        while(!zbir.isEmpty()) {    //sve dok stack zbir nije prazan
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

        int[] y = zbir2VelikaBroja(broj1, broj2);
        for (int i = 0; i < y.length; i++) {
            System.out.println(y[i]);
        }
        System.out.println();
    }
}
