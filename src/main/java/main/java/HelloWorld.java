package main.java;

import covidSciDiscoveries.CovidSciDiscoveries;

public class HelloWorld {

	/** Cumprimenta uma pessoa.
	 * @param name O nome da pessoa.
	*/
	
	public static void sayHiTo(String name) {
		System.out.println("Olá " + name.trim() + "!");
	}
	
	public static void main(String [] args){
		sayHiTo("professor");
		System.out.println(CovidSciDiscoveries.getCovidSciDicoveriesTable());
	}
}
