package com.twitter;
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

	@Before
	public void setUp() throws Exception {
		pom = new Twitter();
	}
	
	@After
	public void tearDown() throws Exception {
		pom = null;
	}

	@Test
	public void testVratiSvePorukeProvjeraDuzine() {
		String korisnik = "Marko";
		String poruka = "Moj prvi tweet.";
		
		for (int i = 0; i < 15; i++) {
			pom.unesi(korisnik, poruka);
		}
		assertEquals(15, pom.vratiSvePoruke().size());	
	}
	
	@Test
	public void testVratiSvePorukeProvjeraSadrzajaPoslednje() {
		LinkedList<TwitterPoruka> postojecePoruke = pom.vratiSvePoruke();
		
		pom.unesi("Marko", "Ovo je moj prvi tweet.");
		
		assertEquals("Marko",postojecePoruke.getLast().getKorisnik());
		assertEquals("Ovo je moj prvi tweet.", postojecePoruke.getLast().getPoruka());
	}
	
	@Test
	public void testVratiSvePorukeProvjeraSadrzajaSvihUnijetih() {
		LinkedList<TwitterPoruka> postojecePoruke = pom.vratiSvePoruke();
		
		pom.unesi("Marko", "Ovo je moj prvi tweet.");
		pom.unesi("Janko", "Ja pisem tweet danas.");
		pom.unesi("Nikola", "Smor brate.");
		
		assertEquals("Marko",postojecePoruke.get(0).getKorisnik());
		assertEquals("Janko",postojecePoruke.get(1).getKorisnik());
		assertEquals("Nikola",postojecePoruke.get(2).getKorisnik());
		
		assertEquals("Ovo je moj prvi tweet.", postojecePoruke.get(0).getPoruka());
		assertEquals("Ja pisem tweet danas.", postojecePoruke.get(1).getPoruka());
		assertEquals("Smor brate.", postojecePoruke.get(2).getPoruka());
	}

	@Test
	public void testUnesi() {
		LinkedList<TwitterPoruka> postojecePoruke = pom.vratiSvePoruke();
		String korisnik = "Marko";
		String  poruka = "Ovo je moj prvi tweet.";
		
		pom.unesi(korisnik, poruka);
		assertEquals(poruka, postojecePoruke.getLast().getPoruka());
	}
	
	@Test
	public void testVratiPoruke() {
		TwitterPoruka[] niz = pom.vratiPoruke(15, "tweet");
		assertEquals(15, niz.length);
	}
	
	@Test
	public void testVratiPorukeNegativnaDuzinaNiza() {
		TwitterPoruka[] niz = pom.vratiPoruke(-1, "tweet");
		assertEquals(100, niz.length);
	}
	
	@Test 
	public void testVratiPorukePraviBroj() {
		int brojac = 0;
		pom.unesi("Marko", "Ovo je moj prvi tweet.");
		pom.unesi("Janko", "Ja pisem tweet danas.");
		pom.unesi("Nikola", "Smor brate.");
		
		TwitterPoruka [] niz = pom.vratiPoruke(10, "tweet");
		for (int i=0;i<niz.length;i++){
			if(niz[i] != null)
				brojac++;
		}
		assertEquals(2, brojac);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNullTag() {
		pom.vratiPoruke(10, null);		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeEmptyTag() {
		pom.vratiPoruke(10, "");		
	}
}
