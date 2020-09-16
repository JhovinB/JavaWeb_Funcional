package com.jbac.javaweb._05_supplier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

import com.jbac.javaweb._03_metodos_de_referencia.Persona;

public class Programa05 {

	public static void main(String[] args) {
		
		Supplier<LocalDateTime> supplierDeHora = ()->LocalDateTime.now();
		System.out.println("Hora actual: "+supplierDeHora.get());
		
		System.out.println();	
		
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
		Supplier<String> supplierConFormato = ()->formatoFecha.format(LocalDateTime.now());
		System.out.println(supplierConFormato.get());
		
		System.out.println();
//		Persona p1 = getPersona(()->new Persona());
		Persona p1 = getPersona(Persona::new);
		Persona p2 = getPersona(()->new Persona("Jhovin",LocalDate.of(1997, 8, 24)));
		
		System.out.println(p1);
		System.out.println(p2);
	}
	
	public static Persona getPersona(Supplier <Persona> supplier) {
		Persona persona = supplier.get();
		if (persona.getNombre()==null) {
			persona.setNombre("Nombre default");
		}
		if (persona.getFechaNacimiento()==null) {
			persona.setFechaNacimiento(LocalDate.of(2000, 1, 1));
		}
		return persona;
	}

}
