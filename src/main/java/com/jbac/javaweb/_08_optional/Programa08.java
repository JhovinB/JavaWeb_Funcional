package com.jbac.javaweb._08_optional;

import java.util.Optional;

public class Programa08 {

	public static void main(String[] args) {
		
		Programa08 pro = new Programa08();
		pro.optionalIntro();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	public void optionalIntro(){
		Optional<String> curso = Optional.of("Java Web Developer");	
		Optional<String> curso2 = Optional.ofNullable(null);	
		
		
		System.out.println("Optional: "+curso);
		System.out.println("Optional value: "+curso.get());
		System.out.println("Optional isPresent: "+curso.isPresent());

		System.out.println("Optional: "+curso2);
		System.out.println("Optional value: "+curso2.orElse("No hay valor"));//orElse->Si e Q NO HAY VALOR retornar orElse("")
		System.out.println("Optional isPresent: "+curso2.isPresent());
		
		System.out.println();
		System.out.println("Optional Empty: "+Optional.empty());
		
	}
}
