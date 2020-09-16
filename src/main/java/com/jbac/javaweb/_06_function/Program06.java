package com.jbac.javaweb._06_function;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import org.apache.commons.codec.digest.DigestUtils;

public class Program06 {

	public static void main(String[] args) {
		
		Function<String, Integer> funcionObtenerTamanio = (cadena)->cadena.length();
		
		System.out.println(funcionObtenerTamanio.apply("Java Web Developer"));
		System.out.println("==========");
		Function<Integer, Boolean> esPar = (numero)->numero%17==0;
		System.out.println("Divisible entre 17: "+esPar.apply(34));
		System.out.println("==========");
		
		String [] estudiantes = {"Jhovin","Maho","Boni"};
		//hash-> para encryptar
		Function<String , String> funcionHash = (nombre)-> DigestUtils.sha256Hex(nombre);
		Map<String, String> mapaHash = new HashMap<>();
		
		
		for (String estudiante : estudiantes) {
			mapaHash.put(estudiante, funcionHash.apply(estudiante));
		}
		
		for (Entry<String, String> elemMapa: mapaHash.entrySet()) {
			System.out.println(elemMapa.getKey()+ " : "+ elemMapa.getValue());
		}
	
	}

}
