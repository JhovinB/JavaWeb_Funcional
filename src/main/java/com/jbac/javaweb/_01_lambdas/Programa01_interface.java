package com.jbac.javaweb._01_lambdas;

public class Programa01_interface {

	public static void main(String[] args) {
		
		Ioperaciones op = new Ioperaciones() {
			
			@Override
			public int operacion(int a, int b) {
				
				return a+b;
			}
			
//			@Override
//			public int resta(int a, int b) {
//				
//				return a-b;
//			}
		};
		
		System.out.println("Suma: " +op.operacion(8,9));
//		System.out.println("Resta: "+op.resta(s10,9));
		
		Ioperaciones op2 = (a,b)->{return a + b;};
		Ioperaciones op3 = (a,b)->a-b;
		
		System.out.println("Suma interfaz: "+op2.operacion(10, 20));
		System.out.println("Suma interfaz: "+op3.operacion(30, 20));
	}

}
interface Ioperaciones {
	int operacion (int a, int b);
	//int resta (int a, int b);
}
