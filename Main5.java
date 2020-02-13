package tydzien1.warsztaty;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main5 {

	public static void main(String[] args){
		String site = "https://szukaj.interia.pl/internet/?q=t%C5%82umaczenia";
		Connection connect = Jsoup.connect(site);

		
			try {
				HashMap<String, Integer> slowa = new HashMap<String, Integer>(); //inicjalizacja hashmapy przed jakąkolwiek pętlą
			    Document document = connect.get();
			    Elements links = document.select("p.snippet");
			    for (Element elem : links) {
			       
			      //każdy tytuł dzielę na słowa po spacjach i wypisanych poniżej znakach
			        StringTokenizer st = new StringTokenizer(elem.text(), ".,!?:-/| ");
			        while (st.hasMoreTokens()) {
			        	String token=st.nextToken();
			        	//usuwam cudzysłowy
			        	token=token.replace("\"", "");
			        	token=token.toLowerCase();
			        	if (token.length()>3) {
			        		if (slowa.containsKey(token))	{
			        			
			        			int wartosc=slowa.get(token);
			        			wartosc++;
			        			slowa.put(token, wartosc);
			        		}
			        		else	{
			        			//jeśli słowa nie ma jest dopisywane z wrtością 1
			        			slowa.put(token, 1);
			        		}
			        	}
			        	//poniższy kod (aż do return result) sortuje mapę po wartościach. wykorzystuje dodatkową klasę ValueComparator
			        	TreeMap<String, Integer> sortedMap = sortMapByValue(slowa); 
			        	
						System.out.println("Najczęściej pojawiające się w tytułach artykułów słowa na stronie: "+site);
						//rozdzielenie mapy na pary: klucz, wartość w celu czytelniejszego wypisania na ekran
						Set<Map.Entry<String, Integer>> pary = sortedMap.entrySet();
						//wypisuję na ekranie posortowaną po wartościach mapę. limit określa po ilu przejściach pętla ma być przerwana
						int limit = 0;
						
						for (Map.Entry<String, Integer> para: pary) {
							if (limit<=10) {
				            System.out.println(para.getKey() + " " + para.getValue()+" powtórzeń");
							}
							else	{
								break;
							}
							limit++;
			} 
			        }
			    }
			} catch (IOException e) {
			    e.printStackTrace();
			}

		

	}

	private static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map) {
		Comparator<String> comparator = new ValueComparator(map);
		//TreeMap is a map sorted by its keys. 
		//The comparator is used to sort the TreeMap by keys. 
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
	}

}
