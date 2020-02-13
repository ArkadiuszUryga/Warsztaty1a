package tydzien1.warsztaty;
//* __2D10+10__: 2 rzuty D10, do wyniku dodaj 10,
//* __D6__: zwykły rzut kostką sześcienną,
//* __2D3__: rzut dwiema kostkami trójściennymi,
//* __D12-1__: rzut kością D12, od wyniku odejmij 1.
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class example {

	public static void main(String[] args) {
	String test1, test2, test3, test4, message, patte;
	test1="2D10+10";
	test2="D6";
	test3="2D3";
	test4="D12-1";
	message="Wpisz kości";
	patte="(\\d*)[d|D](\\d+)([+-]\\d+)?";
	
	ScannerValidation.getStringPattern(message, patte);
	System.out.println("ok");
	}

}
