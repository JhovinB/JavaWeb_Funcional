package com.jbac.javaweb._04_consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Programa04 {

	public static void main(String[] args) {
		
//		consumer();
		biconsumer();
	}
	private static void biconsumer() {
		BiConsumer<Integer, Integer> op = (x,y)->System.out.println(x+y);
		
		operar(5, 9, (a,b)->System.out.println(a+b));
		operar(9, 5, (a,b)->System.out.println(a-b));
		operar(5, 9, (a,b)->System.out.println(a*b));
		operar(9, 5, (a,b)->System.out.println(a/b));
	
		

	}
	private static void operar(int x,int y,BiConsumer<Integer, Integer>consumerOperacion) {
		consumerOperacion.accept(x, y);
	}

	private static void consumer() {
		String [] estudiantes = {"Jhovin","Maho","Boni"};
		
		Consumer<List<String>> consumidorImpresion = (lista)->{
			for (String dato : lista) {
				System.out.println("Hola: "+dato);
			}
		};  
		
		consumidorImpresion.accept(Arrays.asList(estudiantes));
		
		System.out.println();		
		Consumer<List<String>> consumidorModificacion = (lista)->{
			for (int i = 0; i < lista.size(); i++) {
				lista.set(i, (i+1)+"-" +lista.get(i));
			}
		};
		consumidorModificacion.andThen(consumidorImpresion).accept(Arrays.asList(estudiantes));
	}

}
