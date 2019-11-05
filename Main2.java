package tydzien1.warsztaty;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//#### Warsztat: Symulator LOTTO.
//
//Jak wszystkim wiadomo, LOTTO to gra liczbowa polegająca na losowaniu 6 liczb z zakresu 1-49. Zadaniem gracza jest poprawne 
//wytypowanie losowanych liczb. Nagradzane jest trafienie 3, 4, 5 lub 6 poprawnych liczb.
//
//Napisz program, który:
//
//* zapyta o typowane liczby, przy okazji sprawdzi następujące warunki:
//    * czy wprowadzony ciąg znaków jest poprawną liczbą,
//    * czy użytkownik nie wpisał tej liczby już poprzednio,
//    * czy liczba należy do zakresu 1-49,
//* po wprowadzeniu 6 liczb, posortuje je rosnąco i wyświetli na ekranie,
//* wylosuje 6 liczb z zakresu i wyświetli je na ekranie,
//* poinformuje gracza, czy trafił przynajmniej "trójkę".
//
//Aby wylosować 6 liczb z zakresu 1-49 bez powtórzeń możemy utworzyć tablicę z wartościami 1-49, wymieszać jej zawartość i 
//pobrać pierwsze 6 elementów.
//
//Poniższy kod powinien Ci pomóc:
//```java
//Integer[] arr = new Integer[49];
//for (int i = 0; i < arr.length; i++) {
//	arr[i] = i;
//}
//System.out.println(Arrays.toString(arr));
//Collections.shuffle(Arrays.asList(arr));
//System.out.println(Arrays.toString(arr));
//```
//
//Możesz również losować liczby z określonego zakresu (sprawdź w snippetach jak to wykonać) - jeżeli wybierzesz takie 
//rozwiązanie, pamiętaj o sprawdzaniu czy dana wartość nie została wcześniej wylosowana.
public class Main2 {

	public static void main(String[] args) {
System.out.println("Gra symulująca grę w lotto"); //A game simulating a lotto game
System.out.println("Wprowadź teraz kolejno 6 liczb z zakresu 1-49. Dublujące się wartości zostaną zignorowane");
//Now enter six numbers in the range 1-49 in sequence. Duplicate values will be ignored
String message="wprowadź liczbę"; //enter the number
Set<Integer> numbers = new TreeSet<>();
while(numbers.size()<6)	{
	int toCheck=getInt(message);
	if (0<toCheck&&toCheck<50) {
		numbers.add(toCheck);
	}
	else	{
		System.out.println("Pilnuj zakresu (1-49)"); //Watch Range (1-49)
	}
	
	for (Integer integer : numbers) {
	    System.out.print(integer.toString()+", ");
	}
}
System.out.println("\n Wylosowane liczby:"); //randomed numbers
int randomed=0;
Set<Integer> randomNumbers = new TreeSet<>();
while(randomNumbers.size()<6)	{
	randomNumbers.add(rand(49));
}
for (Integer integer : randomNumbers) {
    System.out.print(integer.toString()+", ");
    if (numbers.contains(integer)) {
    	randomed++;
    }
}
System.out.println();
System.out.println("Wylosowano: "+randomed);


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
	private static int rand(int range)	{ //gets random numbers
		
		Random  rands = new Random();
		return rands.nextInt(range)+1;
		
	}

}
