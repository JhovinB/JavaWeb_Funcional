package com.jbac.javaweb._03_metodos_de_referencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Programa03 {
	List<Persona> lista = new ArrayList<Persona>();
	
	
	public Programa03() {
		lista.add(new Persona("Jhovin",LocalDate.now(),1500));
		lista.add(new Persona("Maho",LocalDate.of(1997,8, 24),1900));
		lista.add(new Persona("Boni",LocalDate.of(1998,5, 16),2000));
		lista.add(new Persona("Jbac",LocalDate.of(1998,12, 26),1850));
	}
	
	public static void main(String[] args) {
		
		
		Programa03 pro = new Programa03();
		pro.imprimirLista("Lista Original");
//		pro.referenciaEstatico();
//		pro.referenciaMetodoDeInstancia();
//		pro.referenciaMetodoDeInstanciaObjetoArbitrario();
//		pro.referenciaMetodoDeInstanciaObjetoArbitrario2();
		pro.referenciaAConstructor();
		
	}
	public void referenciaAConstructor() {
		//Version 1
//		IPersona interfaz =(String nombre, LocalDate fechaNacimiento)->new Persona(nombre,fechaNacimiento);
		//Version 2
		IPersona interfaz=Persona::new;
		lista.add(interfaz.crearPersona("Kenia",LocalDate.of(1999,7,12)));
		imprimirLista("Se agrego persona");

		//Version 1
//		IPersona2 interfaz2 =(String nombre, LocalDate fechaNacimiento,Integer salario)->new Persona(nombre,fechaNacimiento,salario);
		//Version 2
		IPersona2 interfaz2 = Persona::new;
		lista.add(interfaz2.crearPersona("Jaya",LocalDate.of(2008,5,10),1000));
		imprimirLista("Se agrego persona");
	}
	public void referenciaMetodoDeInstanciaObjetoArbitrario2() {
		
		String [] estudiantes = {"Jhovin","Maho","Boni"};
		
		for (String estudiante : estudiantes) {
			System.out.println(estudiante);
		}
		
		System.out.println();
		Arrays.sort(estudiantes,(nombre1,nombre2)->nombre1.compareTo(nombre2));
		Arrays.sort(estudiantes,String::compareTo);
		
		for (String estudiante : estudiantes) {
			System.out.println(estudiante);
		}
		
	}
	
	public void referenciaMetodoDeInstanciaObjetoArbitrario() {
//		lista.sort((persona1,persona2)->persona1.ordenarPorEdad(persona2));
		lista.sort((Persona::ordenarPorEdad));
		imprimirLista("Ordenar por edad");
		
		
	}
	public void referenciaMetodoDeInstancia() {
		UtilitarioPersona util = new UtilitarioPersona();
		
//		lista.sort((persona1,persona2)-> util.compararPorNombre(persona1,persona2));
		lista.sort(util::compararPorNombre);
		imprimirLista("Ordenamiento por nombre");
//		lista.sort((persona1,persona2)-> util.compararPorSalario(persona1,persona2));
		lista.sort(util::compararPorSalario);
		imprimirLista("Ordenamiento por salario");
		
	}
	public void referenciaEstatico() {
//		List<Persona> lista = new ArrayList<Persona>();
//		lista.add(new Persona("Jhovin",LocalDate.now(),1500));
//		lista.add(new Persona("Maho",LocalDate.of(1997,8, 24),1900));
//		lista.add(new Persona("Boni",LocalDate.of(1998,5, 16),2000));
//		lista.add(new Persona("Jbac",LocalDate.of(1998,12, 26),1850));
//		
//		lista.sort((persona1,persona2)-> persona1.getFechaNacimiento().compareTo(persona2.getFechaNacimiento()));
//		lista.sort((persona1,persona2)-> Persona.compararPorFechaNacimiento(persona1,persona2));
		lista.sort(Persona::compararPorFechaNacimiento);
		
		imprimirLista("Ordenamiento por método estatico");
	}
	private void imprimirLista(String mensaje) {
		System.out.println(mensaje);
		for (Persona persona : lista) {
			System.out.println(persona);
		}
	}

}


interface IPersona{
	Persona crearPersona(String nombre, LocalDate fechaNacimiento);
}
interface IPersona2{
	Persona crearPersona(String nombre, LocalDate fechaNacimiento,Integer salario);
}