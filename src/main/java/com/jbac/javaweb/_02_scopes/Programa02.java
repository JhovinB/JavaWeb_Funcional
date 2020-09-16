package com.jbac.javaweb._02_scopes;

public class Programa02 {

	static double suma = 50;
	
	public static void main(String[] args) {
		
		int total = 100;
		
		
		Ioperaciones interfaz = (x,y)->{
			
			suma = 30;
			return x+y+total+suma;
		};
		System.out.println("Operacion: "+interfaz.operacion(4,6));
		
	}

}
interface Ioperaciones {
	double operacion (double a, double b);
	
}