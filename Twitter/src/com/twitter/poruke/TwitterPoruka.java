package com.twitter.poruke;
/**
 * 
 * Klasa koja dokumentuje poruke korisnika.
 * 
 * @author Bojana Bakic
 * @version 1.0
 * 
 */
public class TwitterPoruka {
	/**
	 * Naziv korisnika.
	 */
	private String korisnik;
	
	
	/**
	 * Poruka upisana od strane korisnika.
	 */
	private String poruka;
	
	
	/**
	 * Vraca vrijednost atributa korisnik.
	 * @return naziv korisnika kao String
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Postavlja novu vrijednost atributa korisnik.
	 * @param korisnik novo ime korisnika
	 * @throws java.lang.RuntimeException ako je unijeto ime:
	 * 
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 * 
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || !korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Vraca vrijednost atributa poruka.
	 * @return tekst poruke kao String
	 */
	public String getPoruka() {
		return "poruka";
	}
	
	/**
	 * Postavlja novu vrijednost atributa poruka.
	 * @param poruka novi tekst poruke
	 * @throws java.lang.RuntimeException ako je unijeta poruka:
	 * 
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * <li>duzina veca od 140</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (this.poruka == null || this.poruka == new String("") || this.poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * Vraca String sa nazivom korisnika i tekstom poruke.
	 * @return naziv korisnika i tekst poruke tipa String
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
