package com.jbac.javaweb._01_lambdas;

import java.time.LocalDate;

public class Persona {
	
	private String nombre;
	private LocalDate fechaNacimiento;
	private Integer salario;
	
	
	
	
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
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", salario=" + salario + "]";
	}
	
}
