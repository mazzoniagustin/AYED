package ttp1.ejercicio7;
import java.util.Scanner;
import java.util.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		ArrayList<Integer> listaArray = new ArrayList();
		int num = s.nextInt();
		System.out.println ("Ingrese el numero (0 para finalizar) ");
		while (num != 0) {
			listaArray.add(num);
			num = s.nextInt();
		}
		
		for (int elto: listaArray) {
			System.out.println(elto);
		}
		
		// para linkedList hubiese cambiado la importación a java.util.LinkedList y la declaración como LinkedList <Integer> listaLinked.
		
		// Si, existe. for (int i = 0; i < listaArray.size() ; i++) o con un while (!listaArray.isEmpty()) imprimis el get(0) y lo removes.
		

	}

}
