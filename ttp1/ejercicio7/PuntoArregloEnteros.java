package ttp1.ejercicio7;
import java.util.*;

public class PuntoArregloEnteros {

	public static void main(String[] args) {
		ArrayList <Integer> listaEnteros= new ArrayList(Arrays.asList(1,2,3,4));
		
		LinkedList<Integer> listaLinked = new LinkedList(Arrays.asList(5,10,15,20));
		
		System.out.println("La lista es capiúa?" + Metodos.esCapicua(listaEnteros));
		
		ArrayList <Integer> listaCopia = new ArrayList(listaEnteros);
		Metodos.invertirArrayRec(listaCopia);
		Metodos.imprimirListaEnteros(listaCopia);
		

	}

}
