import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

/**
 * 
 */

/**
 * @author Korisnik
 *
 */
public class TwitterTest {
	private Twitter pom;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Twitter pom;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		pom = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		String korisnik = "Marko";
		String poruka = "Moj prvi tweet.";
		
		for (int i = 0; i < 15; i++) {
			pom.unesi(korisnik, poruka);
		}
		assertEquals(15, pom.vratiSvePoruke().size());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		
	}

}
