package tydzien1.warsztaty;

import java.util.Random;

//Warsztat: Gra w zgadywanie liczb 2
//
//Odwróćmy teraz sytuację z warsztatu "Gra w zgadywanie liczb": to użytkownik pomyśli sobie liczbę z zakresu 1-1000, a 
//komputer będzie zgadywał i zrobi to maksymalnie w 10 ruchach (pod warunkiem, że gracz nie będzie oszukiwał).
//
//Zadaniem gracza będzie udzielanie odpowiedzi "więcej", "mniej", "trafiłeś".
///////////////////////////////////
//zrobimy tak, żeby było ciekawiej:
//wartości początkowe: dół zakresu=0, góra zakresu=1000
//jeżeli liczba dostępnych liczb (początkowo 1000) =x to:
//y=x/k
//najrozsądniej byłobyy typować w połowie dostępnego zakresu, ale...
//wylosujemy z zakresu y - 3y
//później w zależności od odpowiedzi będziemy zmieniali dostępne zakresy, ale filozofia pozostanie bez zmian
public class Main3 {

	public static void main(String[] args) {
		System.out.println("Gra w zgadywanie liczb");
		System.out.println("Pomyśl sobie liczbę z zakresu 1-1000");
		System.out.println("Wygrasz, jeżeli nie zgadnę tej liczby w 10 ruchach");
		System.out.println("Po każdym moim typie musisz napisać: 'więcej', 'mniej' lub 'dobrze'");
		System.out.println();
		int min=1;
		int max=1000;
		for (int i=1;i<=10;i++) {
			if (i==1) {
			System.out.println("Próba nr "+i);
			int size=max-min+1;
			int temp=size/4;
			int minA=min+temp-1;
			int maxA=max-temp+1;
			System.out.println("Mój typ to: ");
			System.out.print(randRange(minA, maxA));
			}
			else	{
				
			}
		}
		System.out.println("Wygrałe(a)ś, brakło mi dosłownie jednego ruchu...");

	}
	private static int randRange (int min, int max) {
		
		Random rand = new Random();
		
		return rand.nextInt(max-min)+min;
		
	}

}
