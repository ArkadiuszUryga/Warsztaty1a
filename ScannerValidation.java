package tydzien1.warsztaty;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerValidation {
	
	//pobiera ze skanera liczbę całkowitą
	public static int getInt(String message) {
		Scanner scan= new Scanner(System.in);
		System.out.println(message);
		while (!scan.hasNextInt())	{
    		System.out.println("miała być liczba \n"+message);
    		scan.next();
    		
    	}
    		
    	return scan.nextInt();
    	
    	
		
	}
	
	//pobiera ze skanera double
	
	public static double getDouble(String message) {
		Scanner scan= new Scanner(System.in);
		System.out.println(message);
		
		while (!scan.hasNextDouble())	{
    		System.out.println("miała być liczba (double) \n"+message);
    		scan.next();
    		
    	}
    	
    	return scan.nextDouble();
	}
	
	//pobiera ze skanera stringa o zadanej długości
	public static String getStringLength(String message, int length) {
		Scanner scan= new Scanner(System.in);
		System.out.println(message);
		
		while(scan.next().length()<length) {
			System.out.println("Minimum 3 znaki \n"+message);
    		scan.next();
		}
		
		
		return scan.next();
		
	}
	
	//pobiera ze skanera stringa
	public static String getString(String message)	{
		Scanner scan=new Scanner(System.in);
		System.out.println(message);
		
		return scan.next();
	}
	

		//pobiera ze skanera stringa o konkretnej wartości
				public static String getSpecificString(String... args) {
					Scanner scan= new Scanner(System.in);
					String message="Wpisz swoją odpowiedź";
					System.out.println(message);
					int arrayLength=args.length;
					
					
					
					while(!scan.next().equals(args)) {
						System.out.println("Odpowiedź z konkretnego zakresu \n"+message);
						System.out.println(arrayLength);
			    		scan.next();
					}
					
					
					return scan.next();
					
				}
				
				//pobiera ze skanera stringa wg wzorca
				public static String[] getStringPattern(String message, String patte) {
					Scanner scan= new Scanner(System.in);
					System.out.println(message);
				
					Pattern pattern = Pattern.compile(patte);
					Matcher matcher=pattern.matcher(scan.next());

					
					while(!matcher.matches()) {
						System.out.println("Wpisz tekst wg wzorca \n"+message);
						matcher=pattern.matcher(scan.next());
					}
					String [] result=new String[3];
					
					//result[0]=matcher.group(1);
					//if (matcher.group(1)==null) result[0]="1";
					//else result[0]=matcher.group(1);
					
					if (matcher.group(1)!=null) result[0]=matcher.group(1);
					else result[0]="1";
					
					result[1]=matcher.group(2);
					if (matcher.group(3)!=null) result[2]=matcher.group(3);
					else result[2]="1";
					return result;
					
					
				}
	
	
	
}
