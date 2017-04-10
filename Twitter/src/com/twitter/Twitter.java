package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * 
 * Klasa uz pomoc 2 metode vrsi unos twitova u listu poruke i puni niz objekata tipa TwitterPoruka
 * porukama sa proslijedjenim tagom u vidu parametra
 * @author Bojana Bakic
 * @version 1.0
 *
 */
public class Twitter {
	/**
	 * Lista objekata tipa TwitterPoruka naziva poruke
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
	/**
	 * Metoda koja vraca listu koja sadrzi twitove
	 * @return listu objekata tipa TwitterPoruka
	 */
	
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Metoda koja pravi objekat tipa TwitterPoruka i unosi parametre korisnik i poruka
	 * koji su proslijedjeni i nakon toga je unosi na kraj liste poruke
	 * @param korisnik tipa String predstavlja naziv korisnika
	 * @param poruka tipa String predstavlja tekst poruke
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * Metoda koja vraca niz poruka koje pretrazujemo preko taga kojeg unosimo kao 
	 * parametar metode
	 * @param maxBroj tipa int prestavlja maksimalan broj poruka u nizu
	 * @param tag tipa String predstavlja tag po kojem se poruke pretrazuju
	 * @return niz objekata tipa TwitterPoruka duzine maxBroj koji sadrzi poruke sa pretrazivanim tagom
	 * @throws java.lang.RuntimeException ako je unijeti tag:
	 * 
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}
