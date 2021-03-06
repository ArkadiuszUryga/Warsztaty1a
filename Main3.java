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
		System.out.println("Po każdym moim typie musisz wpisać cyfrę oznaczającą: ");
		System.out.println("1 - 'więcej'");
		System.out.println("2 - 'mniej'");
		System.out.println("3- 'dobrze'");
		System.out.println();
		int min=1;
		int max=1000;
		int attempt = 0;
		for (int i=1;i<=10;i++) {
			if (i==1) {
			System.out.println("Próba nr "+i);
			int size=max-min+1;
			int temp=size/4;
			int minA=min+temp-1;
			int maxA=max-temp+1;
			System.out.print("Mój typ to: ");
			attempt=randRange(minA, maxA);
			System.out.println(attempt);
			
			}
			else	{
				
				String message="Wpisz 1,2 lub 3";
				int typ=ScannerValidation.getInt(message);
				
				if (typ==1) {
					System.out.println("Czyli ma być więcej niż "+ attempt);
					System.out.println("I mniej niż "+ max);
					min=attempt;
					System.out.println("Próba nr "+i);
					int size=max-min+1;
					int temp=size/4;
					int minA=min+temp-1;
					int maxA=max-temp+1;
					System.out.print("Mój typ to: ");
					attempt=randRange(minA, maxA);
					System.out.println(attempt);
					
				}
				else if (typ==2) {
					System.out.println("Czyli ma być mniej niż "+ attempt);
					System.out.println("I więcej niż "+ min);
					System.out.println("Próba nr "+i);
					max=attempt;
					int size=max-min+1;
					int temp=size/4;
					int minA=min+temp-1;
					int maxA=max-temp+1;
					System.out.print("Mój typ to: ");
					attempt=randRange(minA, maxA);
					System.out.println(attempt);
					
				}
				else	{
					System.out.println("Wygrałem, jak zwykle zresztą...");
					System.out.println("Czasem, bardzo rzadko braknie mi może jednego ruchu.");
				}
			}
		}
		System.out.println("Wygrałe(a)ś, brakło mi dosłownie jednego ruchu...");

	}
	private static int randRange (int min, int max) {
		
		Random rand = new Random();
		
		return rand.nextInt(max-min)+min;
		
	}

}
