package System;

import java.util.Locale;

public class ut {
	public void skrivLinje(String tekst){
		System.out.println(tekst);
	}
	
	public void skrivLinje(Object objekt){
		System.out.println(objekt);
	}
	
	public void skrivLinje(){
		System.out.println();
	}
	
	public void skrivLinje(boolean santEllerUsant){
		System.out.println(santEllerUsant);
	}
	
	public void skrivLinje(char bokstav){
		System.out.println(bokstav);
	}
	
	public void skrivLinje(char[] bokstavListe){
		System.out.println(bokstavListe);
	}
	
	public void skrivLinje(double desimalTall){
		System.out.println(desimalTall);
	}
	
	public void skrivLinje(float tall){
		System.out.println(tall);
	}
	
	public void skrivLinje(int heltTall){
		System.out.println(heltTall);
	}
	
	public void skrivLinje(long tall){
		System.out.println(tall);
	}
	
	public void skriv(String tekst){
		System.out.print(tekst);
	}
	
	public void skriv(char bokstav){
		System.out.print(bokstav);
	}
	
	public void skriv(int heltTall){
		System.out.print(heltTall);
	}
	
	public void skriv(boolean santEllerUsant){
		System.out.print(santEllerUsant);
	}
	
	public void skriv(char[] bokstavListe){
		System.out.print(bokstavListe);
	}
	
	public void skriv(double desimal){
		System.out.print(desimal);
	}
	
	public void skriv(float tall){
		System.out.print(tall);
	}
	
	public void skriv(long tall){
		System.out.print(tall);
	}
	
	public void skriv(Object objekt){
		System.out.print(objekt);
	}
	
	public void skrivFormatert(String formattering, Object... args){
		System.out.printf(formattering, args);
	}
	
	public void skrivFormatert(Locale locale, String formattering, Object... args){
		System.out.printf(locale, formattering, args);
	}
}
