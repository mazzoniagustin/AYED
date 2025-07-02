package ttp1.ejercicio7;

import java.util.ArrayList;

public class IncisoD {

	public static void main(String[] args) {
		ArrayList<Estudiante> listaEstudiante = new ArrayList();
		
		Estudiante e1 = new Estudiante("Agustin", "Mazzoni", 22);
		
		listaEstudiante.add(e1);
		
		Estudiante e2 = new Estudiante("Carlos", "Mogollon", 24);
		
		listaEstudiante.add(e2);
		
		Estudiante e3 = new Estudiante("Baltazar", "Menv", 11);
		
		listaEstudiante.add(e3);
		
		ArrayList<Estudiante> nuevaLista = new ArrayList(listaEstudiante);
		
		System.out.println("Imprimir lista original: ");
		Metodos.imprimirLista(listaEstudiante);
		
		System.out.println("Imprimir lista copiada: ");
		Metodos.imprimirLista(nuevaLista);
		
		e1.setNombre("Aggusstin");
		
		System.out.println("Imprimir lista original: ");
		Metodos.imprimirLista(listaEstudiante);
		
		System.out.println("Imprimir lista copiada: ");
		Metodos.imprimirLista(nuevaLista);
		
		Estudiante e4 = new Estudiante ("Tatiana", "Pasini", 12);
		
		listaEstudiante.add(e4);
		
		System.out.println("Imprimir lista original: ");
		Metodos.imprimirLista(listaEstudiante);
		
		System.out.println("Imprimir lista copiada: ");
		Metodos.imprimirLista(nuevaLista);
	}

}
