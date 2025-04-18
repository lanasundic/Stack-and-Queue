/*1.	Napisati program koji u datom izrazu, koji se sastoji od otvorenih i 
zatvorenih malih zagrada, brojem 0 mijenja otvorene zagrade koje su pravilno zatvorene, 
brojem 1 mijenja zatvorene zagrade za koje postoji odgovarajuća otvorena zagrada, 
a brojem -1 nepravilno postavljene otvorene i zatvorene zagrade.

Napomena: Maksimalan broj poena donosi rješenje složenosti O(n), gdje je n broj zagrada.
Primjeri:
ULAZ:			ULAZ:				ULAZ:
(()              ())                      ((())(())) ))
IZLAZ:			IZLAZ:				IZLAZ:
-101             01-1                     0001100111-1-1
*/

import java.util.Scanner;
import java.util.Stack;

public class Zad1 {
    public static int[] zagrade(String izraz) {
        Stack<Integer> stack = new Stack<>();
        
        int n = izraz.length();
        int[] brojevi = new int[n];
        for(int i = 0; i < n; i++) {
            brojevi[i] = -1;    //sve postavljamo na -1 jer pretpostavljamo da nijedna nije validna, pa cemo mijenjati one koje zapravo jesu
        }
        
        for(int i = 0; i < n; i++) {
            char ch = izraz.charAt(i);  //ch = izraz.charAt(i) uzima karakter sa pozicije i — biće ili ( ili ).
            
            if (ch == '(') {    //ako naidjemo na ( guramo je na stack, tako pamtimo gde je ta otvorena zagrada, za slučaj da je kasnije možemo upariti sa nekom ).
                stack.push(i);
            }
            else if (ch == ')') {   //ako naidjes na )
                if (!stack.isEmpty()) {     //ako je stack i dalje pun
                    int pozOtv = stack.pop();   //izbaci otvorenu zagradu iz stacka, jer je to par za )
                    brojevi[pozOtv] = 0;    //na toj poziciji gde je bila (, postavljamo 0
                    brojevi[i] = 1;         //Na trenutnoj poziciji ), postavljamo 1
                }
                else {
                    brojevi[i] = -1;    //ako je stack prazan znaci da ova ) nema s kim da se upari, i stampa se -1, odnosno ako nemamo odgovarajuću (.
                }
            }
        }
            
        return brojevi;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite karaktere:");
        String izraz = scanner.nextLine();  //unoz stringa

        int[] brojevi = zagrade(izraz);

        for (int i = 0; i < brojevi.length; i++) {
            System.out.print(brojevi[i]);
        }
        System.out.println();

        for (int i = 0; i < brojevi.length; i++) {
            System.out.print(brojevi[i]);
        }
        System.out.println();
    }
}

//The charAt() method returns the character at the specified index in a string.
//The index of the first character is 0, the second character is 1, and so on.
