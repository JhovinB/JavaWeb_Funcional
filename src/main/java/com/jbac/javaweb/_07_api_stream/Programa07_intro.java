package com.jbac.javaweb._07_api_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Programa07_intro {

	public static void main(String[] args) {
		
		Programa07_intro pro = new Programa07_intro();
		//pro.introStream();
		//pro.intStream();
		//pro.mapStream2();
		//pro.summaryStatistics();
		pro.flatMap();
	}
	private void flatMap() {
		Persona p1 = new Persona("Jhovin");
		p1.getHabilidades().add("JAVA");
		p1.getHabilidades().add("Python");
		p1.getHabilidades().add("PHP");
		p1.getHabilidades().add("Kotlin");
		
		Persona p2 = new Persona("Maho");
		p2.getHabilidades().add("GoLang");
		p2.getHabilidades().add("Scala");
		p2.getHabilidades().add("Java");
		p2.getHabilidades().add("PHP");
		
		
		List<Persona> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		lista.add(new Persona());
		
		//List<Persona>-->List<String>
		lista.stream()//Stream<Persona>
			.map(persona->persona.getHabilidades())//Stream<List<String>>-->Stream<String>
			.flatMap(lenguaje->lenguaje.stream())//;Stream<String>
			.distinct()
			.forEach(System.out::println);
	
	}
	private void summaryStatistics() {
		IntSummaryStatistics summary = IntStream.of(7,2,19,88,74,100).summaryStatistics();
		System.out.println(summary);
		
		List<Persona> lista = new ArrayList<>();
		lista.add(new Persona("Jhovin",LocalDate.now(),1500));
		lista.add(new Persona("Maho",LocalDate.of(1997,8, 24),1900));
		lista.add(new Persona("Boni",LocalDate.of(1998,5, 16),2000));
		lista.add(new Persona("Jbac",LocalDate.of(1998,12, 26),1850));
		
		System.out.println("Datos de edad: "+lista.stream()//Stream<Persona>
			.mapToInt(persona->persona.getEdad())//Stream<Integer>==IntStream
			.summaryStatistics());
		
		
	}
	
	private void mapStream2() {
		
		try {
			Stream<String> nombreStream = Files.lines(Paths.get("src/main/resources/students.txt"))
					.filter(nombre->nombre.contains("la"));
			
			List<Persona>listaPersonas=nombreStream
		//		.map(nombre->new Persona(nombre))//Stream<Persona>
				.map(Persona::new)
				.collect(Collectors.toList());//List<Persona>				
				listaPersonas.forEach(System.out::println);
			
		} catch (IOException e) {
			System.out.println("Archivo no encontrado");
			e.printStackTrace();
		}
		
		
	}
	private void mapStream() {
		String [] nombres = {"Jhovin","Maho","Boni","mariela","angela"};
		
		Arrays.stream(nombres)//Stream<String>
		.map(nombre->nombre.length())//Stream<Integer>
		.filter(nombreTamanio->nombreTamanio<5)//Stream<Integer>
		.forEach(System.out::println);
		System.out.println("=============");
		Arrays.stream(nombres)//Stream<String>
			.sorted()
			.map(nombre->nombre.toUpperCase())//Stream<String>
			.filter(nombreMayusculas ->nombreMayusculas.contains("LA"))//Stream<String>
			.forEach(System.out::println);
		
		
		
	}
	public void intStream() {
		
	IntStream numeros =	IntStream.range(1,10).skip(2);
		numeros.forEach(System.out::println);
		System.out.println("===============");
		
	IntStream suma =	IntStream.range(1,20);	
		System.out.println(suma.sum());
	}
	public void introStream() {
		List<Persona> lista = new ArrayList<>();
		lista.add(new Persona("Jhovin",LocalDate.now(),1500));
		lista.add(new Persona("Maho",LocalDate.of(1997,8, 24),1900));
		lista.add(new Persona("Boni",LocalDate.of(1998,5, 16),2000));
		lista.add(new Persona("Jbac",LocalDate.of(1998,12, 26),1850));
		
		for (Persona persona : lista) {
			System.out.println(persona);
		}
//		System.out.println();
//		lista.forEach((persona)->System.out.println(persona));
		System.out.println();
		lista.stream().forEach((persona)->System.out.println("Impresion: "+persona));
		System.out.println("===========");
		//filter->nos ayuda a poder tener otra lista aparte segun el criterio que quiero filtrar.
		lista.stream()
			.filter(persona->persona.getEdad()>=18)
			.filter(persona->persona.getNombre().contains("B"))
			.forEach(System.out::println);
		System.out.println("============");
		lista.forEach(System.out::println);
		System.out.println("============");
		
		List<Persona> lista2 = lista.stream()//Stream<Persona>
				.filter(persona->persona.getEdad()>=18)//Stream<Persona>
				.collect(Collectors.toList());//List<Persona>
		lista2.stream().forEach(System.out::println);

	}

}
