package main.java;

public class HelloWorld {

	/** Cumprimenta uma pessoa.
	 * @param name O nome da pessoa.
	*/
	
	public static void sayHiTo(String name) {
		System.out.println("Olá " + name.trim() + "!");
	}
	
	public static void main(String [] args){
		sayHiTo("professor");
		sleep(5000);
	}

}
