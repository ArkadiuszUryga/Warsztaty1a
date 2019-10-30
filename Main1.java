package tydzien1.warsztaty;

import java.util.Random;
import java.util.Scanner;

//Warsztat: Gra w zgadywanie liczb.
//
//Napisz prostą grę w zgadywanie liczb. Komputer musi wylosować liczbę w zakresie od 1 do 100. Następnie:
//
//    Zadać pytanie: "Zgadnij liczbę" i pobrać liczbę z klawiatury.
//    Sprawdzić, czy wprowadzony napis, to rzeczywiście liczba i w razie błędu wyświetlić komunikat "To nie jest liczba", po czym wrócić do pkt. 1
//    Jeśli liczba podana przez użytkownika jest mniejsza niż wylosowana, wyświetlić komunikat "Za mało!", po czym wrócić do pkt. 1.
//    Jeśli liczba podana przez użytkownika jest większa niż wylosowana, wyświetlić komunikat "Za dużo!", po czym wrócić do pkt. 1.
//    Jeśli liczba podana przez użytkownika jest równa wylosowanej, wyświetlić komunikat "Zgadłeś!", po czym zakończyć działanie programu.
//
//Przykład:
//
//Zgadnij liczbę: cześć
//To nie jest liczba.
//Zgadnij liczbę: 50
//Za mało!
//Zgadnij liczbę: 75
//Za dużo!
//Zgadnij liczbę: 63
//Zgadłeś!

public class Main1 {

	public static void main(String[] args) {
		int number=randomNumber();
		String message="Zgadnij liczbę (1-100)";
		int guessed=0;
		while (guessed!=number) {
			guessed=getInt(message);
			if (guessed<number) {
				System.out.println("Za mało");
			}
			else if (guessed>number) {
				System.out.println("Za dużo");
			}
			else System.out.println("Zgadłeś");
		}

	}
	private static int randomNumber()	{ //returns random number between 1 and 100
		
		Random rand = new Random();
		return rand.nextInt(100)+1;
		
	}
	private static int getInt(String message) { //gets a number from the console
		Scanner scan= new Scanner(System.in);
		System.out.println(message);
		while (!scan.hasNextInt())	{
    		System.out.println("miała być liczba \n"+message);
    		scan.next();
    		
    	}
    		
    	return scan.nextInt();
    	
    	
		
	}

}
