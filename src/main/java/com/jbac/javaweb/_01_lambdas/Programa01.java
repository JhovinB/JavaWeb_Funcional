package com.jbac.javaweb._01_lambdas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Programa01 {

	public static void main(String[] args) {
		
		
		comparatorConObjetos();
		
	}
	private static void comparatorConObjetos() {
		
		List<Persona> lista = new ArrayList<Persona>();
		lista.add(new Persona("Jhovin",LocalDate.now(),1500));
		lista.add(new Persona("Maho",LocalDate.of(1997,8, 24),1900));
		lista.add(new Persona("Boni",LocalDate.of(1998,5, 16),2000));
		lista.add(new Persona("Jbac",LocalDate.of(1998,12, 26),1850));
		System.out.println("Lista original");
		for (Persona persona : lista) {
			System.out.println(persona);
		}
		
//		Collections.sort(lista, new Comparator<Persona>() {
//
//			@Override
//			public int compare(Persona persona1, Persona persona2) {
//				return persona1.getNombre().compareTo(persona2.getNombre());
//			}
//			
//		});
//		//Expresión Lambda--Ejemplo v1
//		Collections.sort(lista,(Persona persona1, Persona persona2)->{
//				return persona1.getSalario().compareTo(persona2.getSalario());
//			}
//		);
		//Expresión Lambda--Ejemplo v2
//		Collections.sort(lista,(persona1,persona2)->{
//			return persona1.getSalario().compareTo(persona2.getSalario());
//			}	
//		);
		//Expresion Lambda--Ejemplo v3-> solo tienes una linea de codigo
		Collections.sort(lista,(persona1,persona2)->persona1.getSalario().compareTo(persona2.getSalario()));
		
		System.out.println("Lista ordenada");
		for (Persona persona : lista) {
			System.out.println(persona);
		}
		
	}
	
	private static void comparatorInicial() {
		String [] colores= {"negro","azul","verde","morado"};
		List<String> lista = Arrays.asList(colores);
		System.out.println("Lista original");
		System.out.println(lista);
		System.out.println();
		
		Collections.sort(lista);		
		System.out.println("Lista ascendente");
		System.out.println(lista);
		System.out.println();
//		Collections.sort(lista,Collections.reverseOrder());
//		System.out.println(lista);
//		
		Comparator<String> comparador=new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
						
		};
		
		Collections.sort(lista,comparador);
		System.out.println("Lista con comparador");
		System.out.println(lista);
	}

}
