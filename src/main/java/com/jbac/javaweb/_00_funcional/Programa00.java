package com.jbac.javaweb._00_funcional;

public class Programa00 {
	
	private Integer sumatoria=0;

	
	public static void main(String[] args) {
		
		
		Programa00 p = new  Programa00();
		System.out.println(p.suma2(3, 5));
		System.out.println(p.suma2(3, 5));
		
	
		
	}
	//Función pura-> Recibiendo los mismos valores de parametro, se
	//obtendra el mismo resultado
	public int suma(int a,int b ) {
		return a + b;
	}
	//Función impura->Resultado diferentes para los mismos parametros
	public int suma2(int a,int b ) {
		sumatoria +=suma(a,b); 
		return sumatoria;
	}
	//COMPOSICION DE FUNCIONES -> UNA FUNCION INVOCA A OTRA FUNCION.
}
