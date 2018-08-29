package it.vivek.ejbexample;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class App {
	
	public static void main(String[] args) {
		System.out.println("hello");
	}

	/*public static void main(String[] args) {


		InitialContext ctx;
		try {
			ctx = new InitialContext();
			TimeService ts= (TimeService)ctx.lookup("TimeService");
			ts.getTime("dd/mm/yyyy");
			
			System.out.println("Starting !==================================================!");
			
			System.err.println(ts.getTime("dd/mm/yyyy"));
			System.out.println("Starting !==================================================!");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}*/

}
