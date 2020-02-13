package tydzien1.warsztaty;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.junit.Test;

public class test {

	@Test
	public void testSymbolAsterix() {
	    Pattern pattern = Pattern.compile("uw*ga");
	    assertTrue(pattern.matcher("uwga").matches());
	    assertTrue(pattern.matcher("uwaga").matches());
	    assertTrue(pattern.matcher("uwaaaaaaga").matches());
	    assertFalse(pattern.matcher("uwagaaaa").matches());
	}
}
