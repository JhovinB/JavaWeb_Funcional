package com.jbac.javaweb._03_metodos_de_referencia;

public class UtilitarioPersona {

	
	 public int compararPorNombre(Persona p1, Persona p2) {
		return p1.getNombre().compareTo(p2.getNombre());
	}
	 public int compararPorFechaNacimiento(Persona p1, Persona p2) {
			return p1.getFechaNacimiento().compareTo(p2.getFechaNacimiento());
	}
	 public int compararPorSalario(Persona p1, Persona p2) {
			return p1.getSalario().compareTo(p2.getSalario());
	}
	
}
