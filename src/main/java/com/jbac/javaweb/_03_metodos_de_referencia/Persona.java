package com.jbac.javaweb._03_metodos_de_referencia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona {
	
	private String nombre;
	private LocalDate fechaNacimiento;
	private Integer salario;
	
	public Persona() {
		
	}
	
	
	public Persona(String nombre, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Persona(String nombre, LocalDate fechaNacimiento, Integer salario) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.salario = salario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	public Integer getSalario() {
		return salario;
	}
	public void setSalario(Integer salario) {
		this.salario = salario;
	}
	public static int compararPorFechaNacimiento(Persona p1, Persona p2) {
		return p1.getFechaNacimiento().compareTo(p2.getFechaNacimiento());
	}

	public Integer getEdad() {
		return (int)ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", salario=" + salario
				+ ", Edad=" + getEdad() + "]";
	}
	
	public int ordenarPorEdad(Persona otraPersona) {
//		return this.getEdad().compareTo(otraPersona.getEdad());//ordenar de forma ascendente
		return this.getEdad().compareTo(otraPersona.getEdad())*-1;//multiplicar por -1 para invertir
		
		
		
	}

	
	
	
	
	
}
