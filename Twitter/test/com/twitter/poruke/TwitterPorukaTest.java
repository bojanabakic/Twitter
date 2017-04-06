/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Korisnik
 *
 */
public class TwitterPorukaTest {
	private TwitterPoruka pom;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		pom = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		pom = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		pom.setKorisnik("Marko");
		
		assertEquals("Marko", pom.getKorisnik());
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		pom.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		pom.setKorisnik("");
	}
	
	public void testSetPoruka() {
		pom.setPoruka("Moj prvi tweet.");
		
		assertEquals("Moj prvi tweet.", pom.getPoruka());
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		pom.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString() {
		pom.setPoruka("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPreviseDugacakString() {
		pom.setPoruka("Ovo je moj prvi tweet. Ja sam super osoba. Volim duge setnje po plazi i more."
				+ "Single sam i trazim svoju srodnu dusu. Volim slatke bucmaste djevojke koje vole salu i dobar film"
				+ "uz kokice i kolu. Moj broj je 065 *** ***. Sve zainteresovane javite se, takodje usamljeni parovi."
				+ "Prihvatam pozive iz Srbije i Crne Gore ali volim i Bosanke. "
				+ "Ta bi odeca na tebi izgledala puno bolje kad bi bila razbacana po podu moje spavace sobe."
				+ "Je li to Sunce upravo zasjalo ili si me ti nasmejala?!"
				+ "Znas li da moj jastuk i tvoja kosa izvrsno pasu?! Gej stop.");
	}
	
	public void testToString() {
		pom.setKorisnik("Marko");
		pom.setPoruka("Moj prvi tweet.");
		
		assertEquals("KORISNIK:Marko PORUKA:Moj prvi tweet.", pom.toString());
	}
}
