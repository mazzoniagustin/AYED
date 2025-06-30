package ttp1.ejercicio7;

import java.util.*;


public class Metodos {
	
	public static void agregarEstudiante(ArrayList <Estudiante> lista, Estudiante unEstudiante) {
		boolean ok = false;
		
		for (Estudiante elto: lista) {
			if ((elto.getNombre() == unEstudiante.getNombre()) && (elto.getApellido() == unEstudiante.getApellido())) {
				System.out.println("El estudiante ya existe en la lista.");
				ok = true;
				break;
			}
		}
		if (!ok) {
			lista.add(unEstudiante);
			System.out.println("El estudiante ha sido agregado con exito.");
		}
	}
	
	public static void imprimirLista(ArrayList <Estudiante> lista) {
		for (Estudiante elto: lista) {
			System.out.println(elto.toString() + "\n");
		}
	}
	
	public static boolean esCapicua (ArrayList<Integer> lista) {
		ArrayList <Integer> listaReversa = new ArrayList(lista);
		Collections.reverse(listaReversa);
		return lista.equals(listaReversa);
	}
	
	public static void invertirArrayRec(ArrayList<Integer> lista) {
		invertirArrayList(lista,0,lista.size()-1);
	}
	
	public static void invertirArrayList (ArrayList<Integer> lista,int inicio, int fin) {
		if (inicio < fin) {
			int temp = lista.get(inicio);
			lista.set(inicio, lista.get(fin));
			lista.set(fin, temp);
			invertirArrayList(lista,inicio+1,fin-1);
		}
	}
	
	public static void imprimirListaEnteros (ArrayList<Integer> lista) {
		for (Integer elto: lista) {
			System.out.println(elto);
		}
	}
	
	public static int sumarLinkedList (LinkedList<Integer> lista) {
		return sumaRecursiva(lista,lista.size()-1);
	}
	
	public static int sumaRecursiva (LinkedList<Integer> lista, int indice) {
		if (indice < 0) {
			return 0;
		}
		else {
			return lista.get(indice) + sumaRecursiva(lista,indice-1);
		}
	}
}
